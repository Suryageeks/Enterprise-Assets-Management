package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    List<SubCategory> findByCategoryId(Long id);
}
