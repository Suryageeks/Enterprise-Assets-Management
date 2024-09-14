package com.eam.Fixed.Assets.dto;

import com.eam.Fixed.Assets.utils.StatusEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetsStatusDto {
    private Long id;
    @NotBlank(message = "asset status is must")
    private String assetStatus;
    @NotBlank(message = "is enable is must")
    @Enumerated(EnumType.STRING)
    private StatusEnum isEnabled = StatusEnum.ACTIVE;
}
