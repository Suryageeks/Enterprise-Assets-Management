package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.AssetsStatusDto;
import com.eam.Fixed.Assets.entity.AssetsStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssetsStatusMapper {
    AssetsStatusMapper MAPPER = Mappers.getMapper(AssetsStatusMapper.class);
    AssetsStatusDto mapToAssetStatusDto(AssetsStatus assetsStatus);
    AssetsStatus mapToAssetStatus(AssetsStatusDto assetsStatusDto);
}
