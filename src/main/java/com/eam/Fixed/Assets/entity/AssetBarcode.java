package com.eam.Fixed.Assets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asset_barcode")
public class AssetBarcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_id", nullable = false)
    private String assetId;

    @Column(name = "asset_name", nullable = false)
    private String assetName;

    @Column(name = "sol_id", nullable = false)
    private String solId;

    @Column(name = "branch_name", nullable = false)
    private String branchName;

    @Column(name = "is_FNA_approved", nullable = false)
    private boolean isFNAApproved = false;

    @Column(name = "is_checker_approved", nullable = false)
    private boolean isCheckerApproved = false;

    @Column(name = "approved_checker_id", nullable = false)
    private String checkerID;

    @Column(name = "approved_checker_name", nullable = false)
    private String checkerName;

    @Lob
    @Column(name = "barcode_image", nullable = true)
    private byte[] barcodeImage;

    @Column(name = "regenerated_count", nullable = true)
    private int regeneratedCount = 0;

    @Column(name = "created_at", nullable = false, updatable = false,insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
