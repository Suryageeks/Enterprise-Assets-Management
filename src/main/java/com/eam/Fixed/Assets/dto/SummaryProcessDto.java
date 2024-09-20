package com.eam.Fixed.Assets.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SummaryProcessDto {
    private Long id;
    private String assetId;
    private String assetName;
    private String solId;
    private String branchName;
    @Enumerated(EnumType.STRING)
    private String status;
    private String makerId;
    private String makerName;
    private String checkerId;
    private String checkerName;
    private String fnaId;
    private String fnaMaker;
    private String reconciliationType;
}
