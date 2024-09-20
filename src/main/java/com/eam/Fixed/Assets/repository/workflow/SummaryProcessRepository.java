package com.eam.Fixed.Assets.repository.workflow;

import com.eam.Fixed.Assets.entity.SummaryProcess;
import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface SummaryProcessRepository extends JpaRepository<SummaryProcess, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE summary_process " +
                   "SET asset_name = :assetName, sol_id = :solId, branch_name = :branchName, status = :status, " +
                   "maker_name = :makerName, checker_id = :checkerId, checker_name = :checkerName, fna_id = :fnaId, " +
                   "fna_maker = :fnaMaker, reconciliation_type = :reconciliationType " +
                   "WHERE asset_id = :assetId", nativeQuery = true)
    void bulkUpdateAsset(
            @Param("assetId") String assetId,
            @Param("assetName") String assetName,
            @Param("solId") String solId,
            @Param("branchName") String branchName,
            @Param("status") WorkflowStatusEnum status,
            @Param("makerName") String makerName,
            @Param("checkerId") String checkerId,
            @Param("checkerName") String checkerName,
            @Param("fnaId") String fnaId,
            @Param("fnaMaker") String fnaMaker,
            @Param("reconciliationType") String reconciliationType
    );

    @Query(value = "Select asset_id from summary_process where asset_id in :assetId", nativeQuery = true)
    Set<String> findExistingAssetId(@Param("assetId") Set<String> assetId);
}
