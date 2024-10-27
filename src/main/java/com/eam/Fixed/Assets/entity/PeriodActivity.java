package com.eam.Fixed.Assets.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "period_activity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeriodActivity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "activity_name", nullable = false)
    private String activityName;
    @Column(name = "process_month", nullable = false)
    private String processMonth;
    @Column(name = "process_year", nullable = false)
    private String processYear;
    @Column(name = "period_status", nullable = false)
    private String periodStatus;
    @Column(name = "created_at", nullable = false, updatable = false,insertable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false, insertable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
}
