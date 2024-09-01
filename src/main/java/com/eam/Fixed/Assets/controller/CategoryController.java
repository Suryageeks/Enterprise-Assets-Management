package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.CategoryDto;
import com.eam.Fixed.Assets.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/category")
public class CategoryController {
    private CategoryService  categoryService;
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto category){
        CategoryDto saveCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long id){
        CategoryDto category = categoryService.getCategory(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @GetMapping("/status/{id}")
    public ResponseEntity<String> getStatus(@PathVariable("id") Long id){
        String status = categoryService.getStatus(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
    @PutMapping("/update-status/{id}")
    public ResponseEntity<CategoryDto> updateStatus(@PathVariable("id") Long id){
        CategoryDto status = categoryService.updateStatus(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

}
