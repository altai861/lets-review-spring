package com.example.letsreviewserver.business;

import com.example.letsreviewserver.model.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    @Query("""
        SELECT DISTINCT b FROM Business b
        LEFT JOIN FETCH b.district d
        LEFT JOIN FETCH d.province p
        LEFT JOIN FETCH p.country c
        LEFT JOIN FETCH b.businessMediaList bm
        LEFT JOIN FETCH bm.media m
        LEFT JOIN FETCH b.businessCategoryList bc
        LEFT JOIN bc.category cat
        WHERE (:countryId IS NULL OR c.countryId = :countryId)
            AND (:provinceId IS NULL OR p.provinceId = :provinceId)
            AND (:districtId IS NULL OR d.districtId = :districtId)
            AND (:categoryId IS NULL OR cat.categoryId = :categoryId)
    """)
    List<Business> findWithFilters(
            @Param("countryId") Long countryId,
            @Param("provinceId") Long provinceId,
            @Param("districtId") Long districtId,
            @Param("categoryId") Long categoryId
    );
}
