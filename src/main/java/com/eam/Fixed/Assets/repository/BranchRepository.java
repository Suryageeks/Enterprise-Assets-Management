package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.BranchDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BranchRepository extends JpaRepository<BranchDetails, UUID> {
    Optional<BranchDetails> findBySolId(String soldid);
}
