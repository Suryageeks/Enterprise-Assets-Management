package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.PhysicalAssetsDto;
import com.eam.Fixed.Assets.entity.PhysicalAssets;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhysicalAssetsMapper {
    PhysicalAssetsMapper MAPPER = Mappers.getMapper(PhysicalAssetsMapper.class);
    PhysicalAssetsDto mapToPhysicalAssetDto(PhysicalAssets physicalAssets);
    PhysicalAssets mapToPhysicalAsset(PhysicalAssetsDto physicalAssetsDto);
}
