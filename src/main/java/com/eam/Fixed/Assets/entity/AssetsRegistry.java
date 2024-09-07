package com.eam.Fixed.Assets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Table(name = "assets_registry")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetsRegistry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "assetId",nullable = false,length = 10)
    private String assetId;
    @Column(name = "assetName",nullable = false)
    private String assetName;
    @Column(name = "price",nullable = false,precision = 3)
    private Double Price;
    @Column(name = "categoryId",nullable = false)
    private Long CategoryId;
    @Column(name = "subcategoryId",nullable = false)
    private Long subCategoryId;
    @Column(name = "created_at", nullable = false, updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false, insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
