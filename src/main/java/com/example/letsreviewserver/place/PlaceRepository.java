package com.example.letsreviewserver.place;

import com.example.letsreviewserver.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    @Query("SELECT p FROM Place p " +
            "JOIN p.district d " +
            "JOIN d.province pr " +
            "JOIN pr.country c " +
            "WHERE (:districtId IS NULL OR d.districtId = :districtId) " +
            "AND (:provinceId IS NULL OR pr.provinceId = :provinceId) " +
            "AND (:countryId IS NULL OR c.countryId = :countryId)")
    List<Place> findFilteredPlaces(
            @Param("districtId") Long districtId,
            @Param("provinceId") Long provinceId,
            @Param("countryId") Long countryId
    );
}
