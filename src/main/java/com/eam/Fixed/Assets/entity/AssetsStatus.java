package com.eam.Fixed.Assets.entity;

import com.eam.Fixed.Assets.utils.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "assets_status_control")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetsStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "asset_status",nullable = false)
    private String assetStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "is_enabled",nullable = false)
    private StatusEnum isEnabled = StatusEnum.ACTIVE;
    @Column(name = "created_at",nullable = false,insertable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
}
