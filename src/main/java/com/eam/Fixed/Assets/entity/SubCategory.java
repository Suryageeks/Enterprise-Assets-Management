package com.eam.Fixed.Assets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "subcategory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id",nullable = false)
    private Long id;

    @Column(name = "subcategory_name",nullable = false)
    private String subcategoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    private Category categoryId;

    @Column(name = "created_at",insertable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
}
