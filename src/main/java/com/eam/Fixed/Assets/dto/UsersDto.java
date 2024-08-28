package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private Long id;
    @NotBlank(message = "Emp ID cannot be empty")
    @Digits(fraction = 0,integer = 10,message = "Emp ID must be present")
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
