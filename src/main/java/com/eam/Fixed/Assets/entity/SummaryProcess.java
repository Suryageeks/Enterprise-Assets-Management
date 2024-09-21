package com.eam.Fixed.Assets.entity;

import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "summary_process")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SummaryProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "asset_id", nullable = false)
    private String assetId;

    @Column(name = "asset_name", nullable = false)
    private String assetName;

    @Column(name = "sol_id", nullable = false)
    private String solId;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private WorkflowStatusEnum status;

    @Column(name = "maker_id", nullable = false)
    private String makerId;

    @Column(name = "maker_name", nullable = false)
    private String makerName;

    @Column(name = "checker_id", nullable = false)
    private String checkerId;

    @Column(name = "checker_name", nullable = false)
    private String checkerName;

    @Column(name = "fna_id", nullable = false)
    private String fnaId;

    @Column(name = "fna_maker", nullable = false)
    private String fnaMaker;

    @Column(name = "reconciliation_type", nullable = false)
    private String reconciliationType;

    @Column(name = "process_month",nullable = false)
    private String month;

    @Column(name = "process_year",nullable = false)
    private String year;
}
