package com.example.letsreviewserver.model;

import com.example.letsreviewserver.model.composite.PlaceMediaId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place_media")
public class PlaceMedia {
    @EmbeddedId
    private PlaceMediaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("placeId")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mediaId")
    private Media media;

    @Column(nullable = false)
    private Date createdDatetime;
}
