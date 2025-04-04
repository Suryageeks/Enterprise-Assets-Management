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
@Table(name = "user_role_sol_mapper")
public class UserRoleSol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id",referencedColumnName = "emp_id",nullable = false)
    private Users user;

    @Column(name = "emp_name",nullable = false,length = 300)
    private String empName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",referencedColumnName = "role_id",nullable = false)
    private Roles role;

    @Column(name = "role_name", nullable = false, length = 50, unique = true)
    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sol_id",referencedColumnName = "sol_id",nullable = false)
    private BranchDetails branchDetail;

    @Column(name = "branch_name",nullable = false,length = 50)
    private String branchName;

    @Column(name = "created_at", nullable = false, updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
