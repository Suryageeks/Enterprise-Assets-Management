package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;
import com.eam.Fixed.Assets.entity.UserRoleSol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleSolRepository extends JpaRepository<UserRoleSol, Long> {

    Optional<UserRoleSol> findByEmpIdOrEmpName(String empId, String empName);
}
