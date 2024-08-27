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
public class UsersDto {
    private UUID id;
    @NotBlank(message = "Emp ID cannot be empty")
    @Digits(fraction = 0,integer = 10,message = "Emp ID must be number")
    private String empId;
    @NotBlank(message = "Emp Name cannot be blank")
    private String empName;
    private String address;
    private String state;
    private String district;
    @Digits(fraction = 0,integer = 10,message = "Mobile Number must be within range of 10 numbers")
    private int mobileNumber;
    private String designation;

}
