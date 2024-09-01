package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategory(Long id);
    String getStatus(Long id);
    CategoryDto updateStatus(Long id);
}
