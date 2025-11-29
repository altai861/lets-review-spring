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
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;

    @Column(unique = true, nullable = false)
    private String districtName;

    @Convert(converter = CoordinateListConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<Coordinate> coordinates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provinceId", nullable = false)
    private Province province;

    @Column(nullable = false)
    private Date createdDatetime;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Date modifiedDatetime;

    @Column(nullable = false)
    private Long modifiedBy;
}
