package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDetailsDto {

    private Long id;
    @NotBlank(message = "Sol ID cannot be empty")
    @Digits(fraction =  0,integer = 5,message = "Sol ID must be number")
    private String solId;
    @NotBlank(message = "Branch Name cannot be blank")
    private String branchName;
    private String branchType;

}
