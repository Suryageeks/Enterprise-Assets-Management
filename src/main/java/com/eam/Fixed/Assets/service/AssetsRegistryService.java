package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.AssetsRegistryDto;

import java.util.List;

public interface AssetsRegistryService {
    AssetsRegistryDto createAssets(AssetsRegistryDto assetsRegistryDto);
    AssetsRegistryDto getAssetByCategoryAndSubCategory(Long categoryId,Long subcategoryId);
    List<AssetsRegistryDto> getAllAssets();
}
