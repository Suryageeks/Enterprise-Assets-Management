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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    // For setting up the login credentials globally
    public Optional<Map<String,String>> getUserDetails(String email) {
        String sql = "select u.sol_id,u.emp_name,u.emp_id,u.role_id,u.role_name,us.emp_email from user_role_sol_mapper u\n" +
                        "left outer join users us on us.emp_id = u.emp_id\n" +
                        "where us.emp_email = ?";
        try{
            Map<String,String> mapUsers = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{email},
                    new RowMapper<Map<String, String>>() {
                        @Override
                        public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Map<String,String> userMap = new HashMap<>();
                            userMap.put("sol_id",rs.getString("sol_id"));
                            userMap.put("role",rs.getString("role_name"));
                            userMap.put("emp_id",rs.getString("emp_id"));
                            userMap.put("emp_name",rs.getString("emp_name"));
                            userMap.put("emp_email",rs.getString("emp_email"));
                            userMap.put("role_id",rs.getString("role_id"));
                            return userMap;
                        }
                    }
            );
            return Optional.ofNullable(mapUsers);
        }
        catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
