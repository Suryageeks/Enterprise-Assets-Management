package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;
import java.time.Year;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetsSolDto {
    private Long id;
    @NotBlank(message = "assetId is must")
    private String assetId;
    @NotBlank(message = "solId is must")
    private String solId;
    @NotBlank(message = "month is must")
    private String month;
    @NotBlank(message = "year is must")
    private String year;
}
