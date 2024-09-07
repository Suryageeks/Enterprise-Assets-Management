package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.AssetsSolDto;

public interface AssetsSolService {
    AssetsSolDto mapAssetsSol(AssetsSolDto assetsSolDto);
    AssetsSolDto getAssetSolMap(Long assetId);
    AssetsSolDto updateAssetSolMap(Long id,AssetsSolDto assetsSolDto);
}
