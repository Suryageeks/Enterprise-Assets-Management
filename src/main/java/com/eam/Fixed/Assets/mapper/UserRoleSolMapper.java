package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;
import com.eam.Fixed.Assets.entity.UserRoleSol;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoleSolMapper {

    UserRoleSolMapper MAPPER = Mappers.getMapper(UserRoleSolMapper.class);

    UserRoleSolDto mapToUserRoleSolMapperDto(UserRoleSol userRoleSolMapper);

    UserRoleSol mapToUserRoleSolMapper(UserRoleSolDto userRoleSolDto);
}
