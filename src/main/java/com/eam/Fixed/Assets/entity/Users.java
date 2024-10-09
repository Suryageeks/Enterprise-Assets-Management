package com.eam.Fixed.Assets.entity;

import com.eam.Fixed.Assets.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "emp_id",nullable = false,length = 100,unique = true)
    private String empId;
    @Column(name = "emp_email",nullable = false)
    private String email;
    @Column(name = "emp_name",nullable = false,length = 300)
    private String empName;
    @Column(name = "address",nullable = false,length = 300)
    private String address;
    @Column(name = "state",nullable = false,length = 50)
    private String state;
    @Column(name = "district",nullable = false,length = 50)
    private String district;
    @Column(name = "mobile_number",nullable = false)
    private int mobileNumber;
    @Column(name = "designation",nullable = false,length = 50)
    private String designation;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEnum status;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "created_at", nullable = false, updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false, insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
