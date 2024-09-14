package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.PhysicalAssetsDto;

import java.util.List;

public interface PhysicalAssetsService {
    PhysicalAssetsDto createAssets(PhysicalAssetsDto physicalAssetsDto);
    List<PhysicalAssetsDto> getAllAssets();
    PhysicalAssetsDto updateAssets(String assetId,PhysicalAssetsDto physicalAssetsDto);
    List<PhysicalAssetsDto> getAssetsBySolId(Long solId);
}
