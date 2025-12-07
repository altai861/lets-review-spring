package com.example.letsreviewserver.place;

import com.example.letsreviewserver.model.PlaceMedia;
import com.example.letsreviewserver.model.composite.PlaceMediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PlaceMediaRepository extends JpaRepository<PlaceMedia, PlaceMediaId> {

    @Query("""
        SELECT pm 
        FROM PlaceMedia pm 
        JOIN FETCH pm.media 
        WHERE pm.place.placeId = :placeId
    """)
    List<PlaceMedia> findMediaByPlaceId(@Param("placeId") Long placeId);

    List<PlaceMedia> findByPlace_PlaceId(Long placeId);

    void deleteByPlace_PlaceIdAndMedia_MediaIdIn(Long placeId, Set<Long> mediaIds);
}