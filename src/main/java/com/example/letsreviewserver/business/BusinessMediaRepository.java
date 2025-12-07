package com.example.letsreviewserver.business;

import com.example.letsreviewserver.model.business.BusinessMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BusinessMediaRepository extends JpaRepository<BusinessMedia, Long> {
    @Query("""
        SELECT bm
        FROM BusinessMedia bm
        JOIN FETCH bm.media
        WHERE bm.business.businessId = :businessId
    """)
    List<BusinessMedia> findMediaByBusinessId(@Param("businessId") Long businessId);

    List<BusinessMedia> findByBusiness_BusinessId(Long businessId);

    void deleteByBusiness_BusinessIdAndMedia_MediaIdIn(Long businessId, Set<Long> mediaIds);
}
