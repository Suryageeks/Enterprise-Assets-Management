package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.dto.UserRoleSolDto;
import com.eam.Fixed.Assets.entity.UserRoleSol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRoleSolRepository extends JpaRepository<UserRoleSol, Long> {

    @Query("select u from UserRoleSol u where u.user = :empId or u.empName = :empName")
    Optional<UserRoleSol> findByUserOrEmpName(@Param("empId") String empId, @Param("empName") String empName);
}
