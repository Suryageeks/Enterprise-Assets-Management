package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {
    SubCategoryDto createSubcategory(SubCategoryDto subCategoryDto);
    SubCategoryDto getSubCategory(Long id);
    List<SubCategoryDto> getMappedSubCategoriesByCategoryId(Long categoryId);
    SubCategoryDto updateSubCategory(Long id);
}
