package com.eam.Fixed.Assets.mapper;

import com.eam.Fixed.Assets.dto.UsersDto;
import com.eam.Fixed.Assets.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UsersDto mapToUsersDto(Users users);

    Users mapToUsers(UsersDto usersDto);
}
