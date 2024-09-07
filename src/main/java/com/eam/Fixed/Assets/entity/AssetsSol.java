package com.eam.Fixed.Assets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "assets_sol_mapper")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetsSol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "assetId",nullable = false)
    private String assetId;
    @Column(name = "solId",nullable = false)
    private String solId;
    @Column(name = "month",nullable = false)
    private Month month;
    @Column(name = "year",nullable = false)
    private Year year;
    @Column(name = "created_at", nullable = false, updatable = false,insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false, insertable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
