package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.CategoryDto;
import com.eam.Fixed.Assets.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);
    CategoryDto mapToCategoryDto(Category category);
    Category mapToCategory(CategoryDto categoryDto);
}
