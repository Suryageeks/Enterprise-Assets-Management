package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.UsersDto;
import com.eam.Fixed.Assets.entity.Users;
import com.eam.Fixed.Assets.mapper.UserMapper;
import com.eam.Fixed.Assets.repository.UserRepository;
import com.eam.Fixed.Assets.service.UsersService;
import com.eam.Fixed.Assets.utils.StatusEnum;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class Usersimpl implements UsersService {

    private UserRepository userRepository;
    @Override
    public UsersDto createUser(UsersDto usersDto) {
        Users users = UserMapper.MAPPER.mapToUsers(usersDto);
        Users saveUserDetails = userRepository.save(users);
        return UserMapper.MAPPER.mapToUsersDto(saveUserDetails);
    }

    @Override
    public UsersDto getUserByEmpId(String empId) {
        Users users = userRepository.findByEmpId(empId).orElseThrow(
                () -> new RuntimeException("No User exists")
        );
        return UserMapper.MAPPER.mapToUsersDto(users);
    }

    @Override
    public List<UsersDto> listUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream().map(UserMapper.MAPPER::mapToUsersDto).collect(Collectors.toList());
    }

    @Override
    public String deleteUser(String empId) {
        Users user = userRepository.findByEmpId(empId).orElseThrow(
                () -> new RuntimeException("User Does Not Exists")
        );
        userRepository.deleteByEmpId(user.getEmpId());
        return "User Deleted Successfully";
    }

    @Override
    public UsersDto updateUserDetails(String empId,UsersDto usersDto) {
        Users user = userRepository.findByEmpId(empId).orElseThrow(
                () -> new RuntimeException("No user exists")
        );

        user.setEmpName(usersDto.getEmpName());
        user.setAddress(usersDto.getAddress());
        user.setDistrict(usersDto.getDistrict());
        user.setDesignation(usersDto.getDesignation());
        user.setMobileNumber(usersDto.getMobileNumber());
        user.setState(usersDto.getState());
        user.setStatus(StatusEnum.valueOf(usersDto.getStatus()));

        Users updateDetails = userRepository.save(user);
        return UserMapper.MAPPER.mapToUsersDto(updateDetails);
    }

    @Override
    public String getStatus(String empId) {
        Users user = userRepository.findByEmpId(empId).orElseThrow(
                () -> new RuntimeException("No user exists")
        );

        return user.getStatus().toString();
    }
}
