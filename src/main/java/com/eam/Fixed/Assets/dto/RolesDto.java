package com.eam.Fixed.Assets.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesDto {
    private Long roleId;
    @NotBlank(message = "Role Name cannot be empty")
    private String roleName;
}
