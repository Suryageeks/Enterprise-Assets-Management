package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.SubCategoryDto;
import com.eam.Fixed.Assets.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubCategoryMapper {
    SubCategoryMapper MAPPER = Mappers.getMapper(SubCategoryMapper.class);

    SubCategoryDto mapToSubcategoryDto(SubCategory subCategory);
    SubCategory mapToSubCategory(SubCategoryDto subCategoryDto);
}
