package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetsRegistryDto {
    private Long id;
    @NotBlank(message = "asset id is must")
    private String assetId;
    @NotBlank(message = "asset name is must")
    private String assetName;
    @NotBlank(message = "asset price is must")
    @Digits(fraction = 3,integer = 20,message = "price is must and decimal values upto 3 places")
    private Double price;
    @NotBlank(message = "category id is must")
    private Long categoryId;
    @NotBlank(message = "subcategory id is must")
    private Long subcategoryId;
}
