package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleSolMapperDto {
    private UUID id;
    @NotBlank(message = "Emp ID cannot be empty")
    @Digits(fraction = 0,integer = 10,message = "Emp ID must be within range of 10 numbers")
    private String users;
    @NotBlank(message = "Emp Name cannot be empty")
    private String empName;
    @NotBlank(message = "Role ID cannot be empty")
    private Long roles;
    @NotBlank(message = "Role Name cannot be empty")
    private String roleName;
    @NotBlank(message = "Sol ID cannot be empty")
    @Digits(fraction = 0,integer = 5,message = "Sol ID must be number")
    private String branchDetails;
    @NotBlank(message = "Branch Name cannot be empty")
    private String branchName;
}
