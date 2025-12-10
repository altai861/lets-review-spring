package com.example.letsreviewserver.business;

import com.example.letsreviewserver.model.business.BusinessCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BusinessCategoryRepository extends JpaRepository<BusinessCategory, Long> {
    @Query("""
        SELECT bc
        FROM BusinessCategory bc
        JOIN FETCH bc.category
        WHERE bc.business.businessId = :businessId
    """)
    List<BusinessCategory> findCategoryByBusinessId(@Param("businessId") Long businessId);

    List<BusinessCategory> findByBusiness_BusinessId(Long businessId);

    void deleteByBusiness_BusinessIdAndCategory_CategoryIdIn(Long placeId, Set<Long> categoryIds);


}
