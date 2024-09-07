package com.eam.Fixed.Assets.repository;

import com.eam.Fixed.Assets.entity.AssetsRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetsRegistryRepository extends JpaRepository<AssetsRegistry,Long> {
    @Query("SELECT ar FROM AssetsRegistry ar WHERE ar.CategoryId = :categoryId AND ar.subCategoryId = :subcategoryId")
    Optional<AssetsRegistry> findByCategoryIdAndSubCategoryId(@Param("categoryId") Long categoryId,@Param("subcategoryId") Long subcategoryId);

}
