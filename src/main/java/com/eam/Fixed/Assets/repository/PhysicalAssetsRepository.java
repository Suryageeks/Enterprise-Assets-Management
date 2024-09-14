package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.PhysicalAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PhysicalAssetsRepository extends JpaRepository<PhysicalAssets,Long>{
    Optional<PhysicalAssets> findByAssetId(String assetId);
    List<PhysicalAssets> findAllBySolId(Long solId);
    boolean existsBySolId(Long solId);
}
