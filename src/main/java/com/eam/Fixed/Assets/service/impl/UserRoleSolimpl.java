package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;
import com.eam.Fixed.Assets.entity.BranchDetails;
import com.eam.Fixed.Assets.entity.Roles;
import com.eam.Fixed.Assets.entity.UserRoleSol;
import com.eam.Fixed.Assets.entity.Users;
import com.eam.Fixed.Assets.mapper.UserRoleSolMapper;
import com.eam.Fixed.Assets.repository.BranchRepository;
import com.eam.Fixed.Assets.repository.RolesRepository;
import com.eam.Fixed.Assets.repository.UserRepository;
import com.eam.Fixed.Assets.repository.UserRoleSolRepository;
import com.eam.Fixed.Assets.service.UserRoleSolService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserRoleSolimpl implements UserRoleSolService {

    @Autowired
    private final UserRoleSolRepository userRoleSolRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RolesRepository rolesRepository;
    @Autowired
    private final BranchRepository branchRepository;


    @Override
    public UserRoleSolDto mapUsers(UserRoleSolDto users) {
        String empId = users.getUsers();
        Long roleId = users.getRoles();
        String solId = users.getBranchDetails();

        Users user = userRepository.findByEmpId(empId).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        Roles roles = rolesRepository.findById(roleId).orElseThrow(
                () -> new RuntimeException("Role not found")
        );

        BranchDetails solid = branchRepository.findBySolId(solId).orElseThrow(
                () -> new RuntimeException("SolId is not present")
        );

        UserRoleSol userRoleSol = new UserRoleSol();
        userRoleSol.setUser(user);
        userRoleSol.setEmpName(user.getEmpName());
        userRoleSol.setRole(roles);
        userRoleSol.setRoleName(roles.getRoleName());
        userRoleSol.setBranchDetail(solid);
        userRoleSol.setBranchName(solid.getBranchName());

        UserRoleSol saveData = userRoleSolRepository.save(userRoleSol);
        return UserRoleSolMapper.MAPPER.mapToUserRoleSolMapperDto(saveData);
    }

    @Override
    public List<UserRoleSolDto> getData() {
        List<UserRoleSol> mapList = userRoleSolRepository.findAll();
        return mapList.stream().map(UserRoleSolMapper.MAPPER::mapToUserRoleSolMapperDto).collect(Collectors.toList());
    }

    @Override
    public UserRoleSolDto getUserByIdOrName(String idOrName) {
        Optional<UserRoleSol> user = userRoleSolRepository.findByUserOrEmpName(idOrName,idOrName);
        UserRoleSol userInfo = user.orElseThrow(
                () -> new RuntimeException("User not found")
        );
        return UserRoleSolMapper.MAPPER.mapToUserRoleSolMapperDto(userInfo);
    }


}
