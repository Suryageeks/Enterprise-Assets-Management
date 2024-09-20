package com.eam.Fixed.Assets.repository.workflow;

import com.eam.Fixed.Assets.entity.AssetsRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InitiateRepository extends JpaRepository<AssetsRegistry, Long> {
    @Query(value = """
        SELECT
            p.asset_id,
            p.asset_name,
            p.branch_name,
            p.depriciation_rate,
            p.depriciation_time,
            p.depriciation_value,
            p.price,
            p.solid,
            'PM' AS status
        FROM physical_assets_register p
        JOIN assets_sol_mapper asm
            ON asm.asset_id = p.asset_id
            AND p.solid = :solid
            AND (:month IS NULL OR EXTRACT(MONTH From p.created_at) = :month)
            AND (:year IS NULL OR EXTRACT(YEAR From p.created_at) = :year)
            AND (:assetId IS NULL OR p.asset_id = :assetId)
        WHERE p.solid = :solid
        ORDER BY p.asset_id ASC
    """, nativeQuery = true)
    List<Object[]> fetchAssetInitialStatus(@Param("assetId") String assetId,@Param("solid") String solid,@Param("month") String month,@Param("year") String year);
}
