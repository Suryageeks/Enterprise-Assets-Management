package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmpId(String empId);

    void deleteByEmpId(String empId);
}
