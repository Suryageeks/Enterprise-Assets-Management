package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.SubCategoryDto;
import com.eam.Fixed.Assets.service.SubCategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/subcategory")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;
    @PostMapping
    public ResponseEntity<SubCategoryDto> createSubCategory(@Valid @RequestBody SubCategoryDto subCategoryDto){
        SubCategoryDto createSubcategory = subCategoryService.createSubcategory(subCategoryDto);
        return new ResponseEntity<>(createSubcategory, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<SubCategoryDto> getSubCategory(@PathVariable("id") Long id){
        SubCategoryDto getDetail = subCategoryService.getSubCategory(id);
        return new ResponseEntity<>(getDetail,HttpStatus.OK);
    }
    @GetMapping("all-subcategory/{id}")
    public ResponseEntity<List<SubCategoryDto>> getSubCategoryBasedOnCategoryId(@PathVariable("id") Long categoryId){
        List<SubCategoryDto> getAllCategoryByCategoryId = subCategoryService.getMappedSubCategoriesByCategoryId(categoryId);
        return new ResponseEntity<>(getAllCategoryByCategoryId,HttpStatus.OK);
    }
    @PutMapping("update-subcategory/{id}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(Long id){
        SubCategoryDto updatedSubCategory = subCategoryService.updateSubCategory(id);
        return new ResponseEntity<>(updatedSubCategory,HttpStatus.OK);
    }


}
