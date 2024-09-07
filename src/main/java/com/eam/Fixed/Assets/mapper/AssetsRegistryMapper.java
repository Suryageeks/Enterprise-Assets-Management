package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.AssetsRegistryDto;
import com.eam.Fixed.Assets.entity.AssetsRegistry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssetsRegistryMapper {
    AssetsRegistryMapper MAPPER = Mappers.getMapper(AssetsRegistryMapper.class);
    AssetsRegistryDto mapToAssetDto(AssetsRegistry assetsRegistry);
    AssetsRegistry mapToAsset(AssetsRegistryDto assetsRegistryDto);
}
