package com.example.letsreviewserver.model;

import com.example.letsreviewserver.model.converter.CoordinateListConverter;
import com.example.letsreviewserver.model.nondb.Coordinate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @Column(unique = true, nullable = false)
    private String countryName;

    @Convert(converter = CoordinateListConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<Coordinate> coordinates;

    @Column(nullable = false)
    private Date createdDatetime;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Date modifiedDatetime;

    @Column(nullable = false)
    private Long modifiedBy;
}
