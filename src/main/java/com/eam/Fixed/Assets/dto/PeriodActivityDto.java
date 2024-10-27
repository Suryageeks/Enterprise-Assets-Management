package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeriodActivityDto {
    private Long id;
    @NotBlank(message = "activity name is must")
    private String activityName;
    @NotBlank(message = "process month is must")
    private String processMonth;
    @NotBlank(message = "process year is must")
    private String processYear;
    @NotBlank(message = "period status is must")
    private String periodStatus;
}
