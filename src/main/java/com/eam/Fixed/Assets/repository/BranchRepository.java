package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.BranchDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface BranchRepository extends JpaRepository<BranchDetails, Long> {
    Optional<BranchDetails> findBySolId(String soldid);
}
