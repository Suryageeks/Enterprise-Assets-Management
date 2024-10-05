package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.AssetBarcodeDto;
import com.eam.Fixed.Assets.entity.AssetBarcode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssetBarcodeMapper {
    AssetBarcodeMapper MAPPER = Mappers.getMapper(AssetBarcodeMapper.class);
    AssetBarcodeDto mapToAssetBarcodeDto(AssetBarcode assetBarcode);
    AssetBarcode mapToAssetBarcode(AssetBarcodeDto assetBarcodeDto);
}
