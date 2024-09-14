package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmpId(String empId);

    void deleteByEmpId(String empId);
}
