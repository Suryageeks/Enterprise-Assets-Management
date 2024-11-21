package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.AssetBarcodeDto;
import com.eam.Fixed.Assets.service.AssetBarcodeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/barcode")
public class AssetBarcodeController {
    private final AssetBarcodeService assetBarcodeService;

    @PostMapping("/generate")
    public ResponseEntity<AssetBarcodeDto> createBarcode(@RequestBody AssetBarcodeDto assetBarcodeDto){
        AssetBarcodeDto generateBarcode = assetBarcodeService.barcodeCreation(assetBarcodeDto);
        return new ResponseEntity<>(generateBarcode, HttpStatus.CREATED);
    }

    @PostMapping(value = "/scan", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String readBarcode(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] barcodeByte = file.getBytes();
        return assetBarcodeService.readBarcode(barcodeByte);
    }

    @PostMapping("/approve")
    public ResponseEntity<AssetBarcodeDto> checkerApprover(@RequestBody AssetBarcodeDto assetBarcodeDto){
        AssetBarcodeDto approver = assetBarcodeService.checkerApprover(assetBarcodeDto);
        return new ResponseEntity<>(approver, HttpStatus.ACCEPTED);
    }
}
