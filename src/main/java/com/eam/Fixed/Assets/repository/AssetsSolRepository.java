package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.AssetsSol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsSolRepository extends JpaRepository<AssetsSol,Long> {
}
