package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategoryDto {
    private Long id;
    @NotBlank(message = "Category Name cannot be empty")
    private String categoryName;
    @NotBlank(message = "CategoryId cannot be empty")
    private Long categoryId;
}
