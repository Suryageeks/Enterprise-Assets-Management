package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.AssetsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsStatusRepository extends JpaRepository<AssetsStatus,Long> {
}
