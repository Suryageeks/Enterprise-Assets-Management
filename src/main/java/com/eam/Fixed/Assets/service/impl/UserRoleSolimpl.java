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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserRoleSolimpl implements UserRoleSolService {

    private final UserRoleSolRepository userRoleSolRepository;
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public UserRoleSolimpl(UserRoleSolRepository userRoleSolRepository, UserRepository userRepository, RolesRepository rolesRepository, BranchRepository branchRepository) {
        this.userRoleSolRepository = userRoleSolRepository;
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.branchRepository = branchRepository;
    }

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
        userRoleSol.setUsers(user);
        userRoleSol.setEmpName(user.getEmpName());
        userRoleSol.setRoles(roles);
        userRoleSol.setRoleName(roles.getRoleName());
        userRoleSol.setBranchDetails(solid);
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
        Optional<UserRoleSol> user = userRoleSolRepository.findByEmpIdOrEmpName(idOrName,idOrName);
        UserRoleSol userInfo = user.orElseThrow(
                () -> new RuntimeException("User not found")
        );
        return UserRoleSolMapper.MAPPER.mapToUserRoleSolMapperDto(userInfo);
    }


}
