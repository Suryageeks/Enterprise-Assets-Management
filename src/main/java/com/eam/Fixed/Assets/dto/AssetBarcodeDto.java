package com.eam.Fixed.Assets.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetBarcodeDto {
    private String assetId;
    private String solId;
    private boolean isCheckerApproved = false;
    private String checkerID;
}
