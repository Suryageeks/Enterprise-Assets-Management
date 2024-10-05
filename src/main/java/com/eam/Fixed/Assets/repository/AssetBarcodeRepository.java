package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.AssetBarcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetBarcodeRepository extends JpaRepository<AssetBarcode, Long> {
    Optional<AssetBarcode> findByAssetIdAndSolId(String assetId, String solId);
}
