package com.eam.Fixed.Assets.service.impl;

import com.aspose.barcode.barcoderecognition.BarCodeReader;
import com.aspose.barcode.barcoderecognition.BarCodeResult;
import com.aspose.barcode.barcoderecognition.DecodeType;
import com.aspose.barcode.generation.BarCodeImageFormat;
import com.aspose.barcode.generation.BarcodeGenerator;
import com.aspose.barcode.generation.CodeLocation;
import com.aspose.barcode.generation.EncodeTypes;
import com.eam.Fixed.Assets.dto.AssetBarcodeDto;
import com.eam.Fixed.Assets.entity.*;
import com.eam.Fixed.Assets.repository.*;
import com.eam.Fixed.Assets.service.AssetBarcodeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
@AllArgsConstructor
public class AssetBarcodeImpl implements AssetBarcodeService {
    private AssetBarcodeRepository assetBarcodeRepository;

    private AssetsRegistryRepository assetsRegistryRepository;
    private BranchRepository branchRepository;
    private AssetsSolRepository assetsSolRepository;
    private UserRepository userRepository;

    @Override
    public byte[] barcodeGeneration(String assetId) {
        BarcodeGenerator barcodeGenerator = new BarcodeGenerator(EncodeTypes.ISBN);
        barcodeGenerator.setCodeText(assetId);

        barcodeGenerator.getParameters().getBarcode().getXDimension().setMillimeters(3);
        barcodeGenerator.getParameters().getBarcode().getCodeTextParameters().setLocation(CodeLocation.BELOW);

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            barcodeGenerator.save(baos.toString(), BarCodeImageFormat.JPEG);
            return  baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate barcode image", e);
        }
    }

    @Transactional
    @Override
    public AssetBarcodeDto barcodeCreation(AssetBarcodeDto assetBarcodeDto) {
        AssetsRegistry assetsRegistry = assetsRegistryRepository.findByAssetId(assetBarcodeDto.getAssetId()).orElseThrow(
                () -> new RuntimeException("Asset Id not present")
        );
        String assetName = assetsRegistry.getAssetName();

        BranchDetails branchDetails = branchRepository.findBySolId(assetBarcodeDto.getSolId()).orElseThrow(
                () -> new RuntimeException("Sol Id not present")
        );
        String branchName = branchDetails.getBranchName();

        boolean exists = assetsSolRepository.existsByAssetIdAndSolId(assetsRegistry.getAssetId(), branchDetails.getSolId());
        if(!exists){
            throw new RuntimeException("Sol ID and Asset ID does not match");
        }

        byte[] barcode = barcodeGeneration(assetsRegistry.getAssetId());

        AssetBarcode assetBarcode = new AssetBarcode();
        assetBarcode.setAssetId(assetBarcodeDto.getAssetId());
        assetBarcode.setAssetName(assetsRegistry.getAssetName());
        assetBarcode.setSolId(assetBarcodeDto.getSolId());
        assetBarcode.setBranchName(branchDetails.getBranchName());
        assetBarcode.setFNAApproved(true);
        assetBarcode.setCheckerApproved(false);
        assetBarcode.setBarcodeImage(barcode);
        assetBarcodeRepository.save(assetBarcode);

        AssetBarcodeDto assetBarcodeDto1 = new AssetBarcodeDto();
        assetBarcodeDto1.setAssetId(assetsRegistry.getAssetId());
        assetBarcodeDto1.setSolId(branchDetails.getSolId());
        assetBarcodeDto1.setCheckerApproved(false);
        return assetBarcodeDto1;
    }

    @Override
    public AssetBarcodeDto checkerApprover(AssetBarcodeDto assetBarcodeDto) {
        AssetBarcode assetBarcode = assetBarcodeRepository.findByAssetIdAndSolId(assetBarcodeDto.getAssetId(), assetBarcodeDto.getSolId()).orElseThrow(
                () -> new RuntimeException("Data not present")
        );

        Users user = userRepository.findByEmpId(assetBarcodeDto.getCheckerID()).orElseThrow(
                () -> new RuntimeException("User Id not match")
        );

        AssetBarcode assetBarcode1 = new AssetBarcode();
        assetBarcode1.setCheckerApproved(true);
        assetBarcode1.setCheckerID(user.getEmpId());
        assetBarcode1.setCheckerName(user.getEmpName());
        assetBarcodeRepository.save(assetBarcode1);

        AssetBarcodeDto assetBarcodeDto1 = new AssetBarcodeDto();
        assetBarcodeDto1.setCheckerApproved(true);
        assetBarcodeDto1.setCheckerID(user.getEmpId());

        return assetBarcodeDto1;
    }

    @Override
    @Transactional
    public String readBarcode(byte[] barcodeValue){
        try(ByteArrayInputStream bias = new ByteArrayInputStream(barcodeValue)){
            BarCodeReader barCodeReader = new BarCodeReader(bias, DecodeType.ALL_SUPPORTED_TYPES);
            for(BarCodeResult res : barCodeReader.readBarCodes()){
                return res.getCodeText();
            }
        }catch (IOException e){
            throw new RuntimeException("Failed to read barcode: "+ e.getMessage());
        }
        throw new RuntimeException("No barcode detected in the image");
    }
}
