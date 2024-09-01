package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.SubCategoryDto;
import com.eam.Fixed.Assets.entity.Category;
import com.eam.Fixed.Assets.entity.SubCategory;
import com.eam.Fixed.Assets.mapper.SubCategoryMapper;
import com.eam.Fixed.Assets.repository.CategoryRepository;
import com.eam.Fixed.Assets.repository.SubCategoryRepository;
import com.eam.Fixed.Assets.service.SubCategoryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class SubCategoryimpl implements SubCategoryService {
    @Autowired
    private final SubCategoryRepository subCategoryRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public SubCategoryDto createSubcategory(SubCategoryDto subCategoryDto) {
        Category checkCategory = categoryRepository.findById(subCategoryDto.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category does not exists")
        );

        SubCategory subCategory = new SubCategory();
        subCategory.setSubcategoryName(subCategory.getSubcategoryName());
        subCategory.setCategoryId(subCategory.getCategoryId());
        subCategoryRepository.save(subCategory);
        return SubCategoryMapper.MAPPER.mapToSubcategoryDto(subCategory);
    }

    @Override
    public SubCategoryDto getSubCategory(Long id) {
        SubCategory getSubCategoryId = subCategoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("SubCategory does not exists")
        );

        return SubCategoryMapper.MAPPER.mapToSubcategoryDto(getSubCategoryId);
    }

    @Override
    public List<SubCategoryDto> getMappedSubCategoriesByCategoryId(Long categoryId) {
        Category checkCategoryId = categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException("Category does not exists")
        );
        List<SubCategory> subCategories = subCategoryRepository.findByCategoryId(categoryId);
        return subCategories.stream().map(SubCategoryMapper.MAPPER::mapToSubcategoryDto).collect(Collectors.toList());
    }

    @Override
    public SubCategoryDto updateSubCategory(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("SubCategory does not exists")
        );
        subCategory.setSubcategoryName(subCategory.getSubcategoryName());
        SubCategory saveUpdatedSubCategory = subCategoryRepository.save(subCategory);
        return SubCategoryMapper.MAPPER.mapToSubcategoryDto(saveUpdatedSubCategory);
    }
}
