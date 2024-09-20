package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.SubCategoryDto;
import com.eam.Fixed.Assets.entity.Category;
import com.eam.Fixed.Assets.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubCategoryMapper {
    SubCategoryMapper MAPPER = Mappers.getMapper(SubCategoryMapper.class);

    @Mapping(source = "categoryId", target = "categoryId")
    SubCategoryDto mapToSubcategoryDto(SubCategory subCategory);

    @Mapping(source = "categoryId", target = "categoryId")
    SubCategory mapToSubCategory(SubCategoryDto subCategoryDto);

    default Long map(Category category) {
        return category != null ? category.getId() : null;
    }

    default Category map(Long categoryId) {
        if (categoryId == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryId);
        return category;
    }

}
