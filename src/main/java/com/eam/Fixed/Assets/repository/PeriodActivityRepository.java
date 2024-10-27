package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.PeriodActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PeriodActivityRepository extends JpaRepository<PeriodActivity, Long> {
    Optional<PeriodActivity> findByProcessMonthAndProcessYear(String processMonth, String processYear);
}
