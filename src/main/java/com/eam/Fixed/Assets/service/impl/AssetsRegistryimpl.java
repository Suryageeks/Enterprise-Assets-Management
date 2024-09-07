package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.AssetsRegistryDto;
import com.eam.Fixed.Assets.entity.AssetsRegistry;
import com.eam.Fixed.Assets.entity.Category;
import com.eam.Fixed.Assets.entity.SubCategory;
import com.eam.Fixed.Assets.mapper.AssetsRegistryMapper;
import com.eam.Fixed.Assets.repository.AssetsRegistryRepository;
import com.eam.Fixed.Assets.repository.CategoryRepository;
import com.eam.Fixed.Assets.repository.SubCategoryRepository;
import com.eam.Fixed.Assets.service.AssetsRegistryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Transactional
public class AssetsRegistryimpl implements AssetsRegistryService {

    private AssetsRegistryRepository assetsRegistryRepository;
    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    @Override
    public AssetsRegistryDto createAssets(AssetsRegistryDto assetsRegistryDto) {
        Category checkCategoryExists = categoryRepository.findById(assetsRegistryDto.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category Id does not exists")
        );

        SubCategory checkSubcategoryExists = subCategoryRepository.findById(assetsRegistryDto.getSubcategoryId()).orElseThrow(
                ()-> new RuntimeException("SubCategory does not exists")
        );

        AssetsRegistry createassets = AssetsRegistryMapper.MAPPER.mapToAsset(assetsRegistryDto);
        AssetsRegistry saveassets = assetsRegistryRepository.save(createassets);
        return AssetsRegistryMapper.MAPPER.mapToAssetDto(saveassets);

    }

    @Override
    public AssetsRegistryDto getAssetByCategoryAndSubCategory(Long categoryId, Long subcategoryId) {
        Category checkCategoryExists = categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException("Category Id does not exists")
        );

        SubCategory checkSubcategoryExists = subCategoryRepository.findById(subcategoryId).orElseThrow(
                ()-> new RuntimeException("SubCategory does not exists")
        );

        Optional<AssetsRegistry> getAssets = assetsRegistryRepository.findByCategoryIdAndSubCategoryId(categoryId,subcategoryId);

        AssetsRegistry asset = getAssets.orElseThrow(
                () -> new RuntimeException("Assets Not Available")
        );

        return AssetsRegistryMapper.MAPPER.mapToAssetDto(asset);
    }

    @Override
    public List<AssetsRegistryDto> getAllAssets() {
        List<AssetsRegistry> allAssets = assetsRegistryRepository.findAll();
        return allAssets.stream().map(val -> AssetsRegistryMapper.MAPPER.mapToAssetDto(val)).collect(Collectors.toList());
    }
}
