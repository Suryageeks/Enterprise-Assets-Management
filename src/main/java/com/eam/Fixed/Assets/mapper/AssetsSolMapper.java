package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.AssetsSolDto;
import com.eam.Fixed.Assets.entity.AssetsSol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssetsSolMapper {
    AssetsSolMapper MAPPER = Mappers.getMapper(AssetsSolMapper.class);
    AssetsSolDto mapToAssetSolDto(AssetsSol assetsSol);
    AssetsSol mapToAssetSol(AssetsSolDto assetsSolDto);
}
