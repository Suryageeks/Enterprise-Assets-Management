package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
