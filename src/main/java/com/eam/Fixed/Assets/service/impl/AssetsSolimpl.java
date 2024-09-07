package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.AssetsSolDto;
import com.eam.Fixed.Assets.entity.AssetsRegistry;
import com.eam.Fixed.Assets.entity.AssetsSol;
import com.eam.Fixed.Assets.mapper.AssetsSolMapper;
import com.eam.Fixed.Assets.repository.AssetsRegistryRepository;
import com.eam.Fixed.Assets.repository.AssetsSolRepository;
import com.eam.Fixed.Assets.service.AssetsSolService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AssetsSolimpl implements AssetsSolService {
    @Autowired
    private AssetsSolRepository assetsSolRepository;
    @Autowired
    private AssetsRegistryRepository assetsRegistryRepository;
    @Override
    public AssetsSolDto mapAssetsSol(AssetsSolDto assetsSolDto) {
        Optional<AssetsRegistry> checkAssetPresentORNot = assetsRegistryRepository.findByAssetId(assetsSolDto.getAssetId());
        AssetsRegistry getAsset = checkAssetPresentORNot.orElseThrow(
                () -> new RuntimeException("Assets Not Available")
        );
        AssetsSol createSolMapper = AssetsSolMapper.MAPPER.mapToAssetSol(assetsSolDto);
        AssetsSol saveMapper = assetsSolRepository.save(createSolMapper);
        return AssetsSolMapper.MAPPER.mapToAssetSolDto(saveMapper);
    }

    @Override
    public AssetsSolDto getAssetSolMap(Long assetId) {
        AssetsSol getAssetMapped = assetsSolRepository.findById(assetId).orElseThrow(
                ()->new RuntimeException("Asset Not Available")
        );

        return AssetsSolMapper.MAPPER.mapToAssetSolDto(getAssetMapped);
    }

    @Override
    public AssetsSolDto updateAssetSolMap(Long id,AssetsSolDto assetsSolDto) {
        AssetsSol getAssetMapped = assetsSolRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Asset Not Available")
        );

        getAssetMapped.setSolId(assetsSolDto.getSolId());
        AssetsSol updateAssetMapper = assetsSolRepository.save(getAssetMapped);
        return AssetsSolMapper.MAPPER.mapToAssetSolDto(updateAssetMapper);
    }
}
