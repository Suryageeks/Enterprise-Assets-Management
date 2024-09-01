package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.CategoryDto;
import com.eam.Fixed.Assets.entity.Category;
import com.eam.Fixed.Assets.mapper.CategoryMapper;
import com.eam.Fixed.Assets.repository.CategoryRepository;
import com.eam.Fixed.Assets.service.CategoryService;
import com.eam.Fixed.Assets.utils.StatusEnum;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class Categoryimpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.MAPPER.mapToCategory(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return CategoryMapper.MAPPER.mapToCategoryDto(saveCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories.stream().map(val -> CategoryMapper.MAPPER.mapToCategoryDto(val)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Long id) {
        Category checkCategory = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category Doesnt Exists")
        );

        return CategoryMapper.MAPPER.mapToCategoryDto(checkCategory);
    }

    @Override
    public String getStatus(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category Doesnt Exists")
        );
        return category.getStatus().toString();
    }

    @Override
    public CategoryDto updateStatus(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category Doesnt Exists")
        );


        if(category.getStatus() == StatusEnum.ACTIVE){
            category.setStatus(StatusEnum.INACTIVE);
        }
        else{
           category.setStatus(StatusEnum.ACTIVE);
        }

        Category saveUpdatedCategory = categoryRepository.save(category);
        return CategoryMapper.MAPPER.mapToCategoryDto(saveUpdatedCategory);
    }
}
