package com.eam.Fixed.Assets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "physical_assets_register")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhysicalAssets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="assetId",nullable = false,unique = true)
    private String assetId;
    @Column(name = "assetName",nullable = false)
    private String assetName;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "depriciation_rate",nullable = false,precision = 3)
    private Double depriciation_rate;
    @Column(name = "depriciation_time",nullable = false)
    private Double depriciation_time;
    @Column(name = "depriciation_value",nullable = false)
    private Double depriciation_value;
    @Column(name = "solid",nullable = false)
    private Long solId;
    @Column(name = "branchName",nullable = false)
    private String branchName;
    @Column(name = "created_at", nullable = false, updatable = false,insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false, insertable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

}
