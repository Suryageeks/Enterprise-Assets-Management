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

public class PhysicalAssetsDto {
    private Long id;
    @NotBlank(message = "assets id is must")
    private String assetId;
    @NotBlank(message = "asset name is must")
    private String assetName;
    @NotBlank(message = "asset price is must")
    @Digits(fraction = 3,integer = 20,message = "asset price must be of 3 decimal places")
    private Double price;
    @NotBlank(message = "depriciation rate is must")
    @Digits(fraction = 3,integer = 3,message = "rate must be of 3 decimal places and max upto 3 integer places")
    private Double depriciation_rate;
    @NotBlank(message = "depriciation time is must")
    @Digits(fraction = 3,integer = 3,message = "dep time must of 3 places")
    private Double depriciation_time;
    @NotBlank(message = "depriciation value is must")
    private Double depriciation_value;
    @NotBlank(message = "sol id is must")
    private Long solId;
    @NotBlank(message = "branch name is must")
    private String branchName;
}
