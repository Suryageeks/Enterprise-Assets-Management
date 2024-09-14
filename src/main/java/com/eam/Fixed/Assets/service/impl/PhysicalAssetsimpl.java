package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.PhysicalAssetsDto;
import com.eam.Fixed.Assets.entity.PhysicalAssets;
import com.eam.Fixed.Assets.mapper.PhysicalAssetsMapper;
import com.eam.Fixed.Assets.repository.PhysicalAssetsRepository;
import com.eam.Fixed.Assets.service.PhysicalAssetsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Transactional
public class PhysicalAssetsimpl implements PhysicalAssetsService {
    private PhysicalAssetsRepository physicalAssetsRepository;
    @Override
    public PhysicalAssetsDto createAssets(PhysicalAssetsDto physicalAssetsDto) {
        PhysicalAssets createAssets = PhysicalAssetsMapper.MAPPER.mapToPhysicalAsset(physicalAssetsDto);
        PhysicalAssets saveAssets = physicalAssetsRepository.save(createAssets);
        return PhysicalAssetsMapper.MAPPER.mapToPhysicalAssetDto(saveAssets);
    }

    @Override
    public List<PhysicalAssetsDto> getAllAssets() {
        List<PhysicalAssets> getAssets = physicalAssetsRepository.findAll();
        return getAssets.stream().map(val -> PhysicalAssetsMapper.MAPPER.mapToPhysicalAssetDto(val)).collect(Collectors.toList());
    }

    @Override
    public PhysicalAssetsDto updateAssets(String assetId, PhysicalAssetsDto physicalAssetsDto) {
        PhysicalAssets getAsset = physicalAssetsRepository.findByAssetId(assetId).orElseThrow(
                () -> new RuntimeException("Asset Id Not Found")
        );
        getAsset.setBranchName(physicalAssetsDto.getBranchName());
        getAsset.setSolId(physicalAssetsDto.getSolId());
        getAsset.setDepriciation_rate(physicalAssetsDto.getDepriciation_rate());
        getAsset.setDepriciation_time(physicalAssetsDto.getDepriciation_time());
        getAsset.setDepriciation_value(physicalAssetsDto.getDepriciation_value());
        getAsset.setPrice(physicalAssetsDto.getPrice());
        PhysicalAssets updateAsset = physicalAssetsRepository.save(getAsset);
        return PhysicalAssetsMapper.MAPPER.mapToPhysicalAssetDto(updateAsset);
    }

    @Override
    public List<PhysicalAssetsDto> getAssetsBySolId(Long solId) {
       if(!physicalAssetsRepository.existsBySolId(solId)){
           new RuntimeException("Sol Id does not exists");
       }
       List<PhysicalAssets> getAllAssetBySol = physicalAssetsRepository.findAllBySolId(solId);
       if(getAllAssetBySol.isEmpty()){
           new RuntimeException("No Assets are mapped to solId: "+solId);
       }
       return getAllAssetBySol.stream().map(val -> PhysicalAssetsMapper.MAPPER.mapToPhysicalAssetDto(val)).collect(Collectors.toList());
    }
}
