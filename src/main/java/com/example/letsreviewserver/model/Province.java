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
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provinceId;

    @Column(unique = true, nullable = false)
    private String provinceName;

    @Convert(converter = CoordinateListConverter.class)
    @Column(columnDefinition = "TEXT")
    private List<Coordinate> coordinates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", nullable = false)
    private Country country;

    @Column(nullable = false)
    private Date createdDatetime;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Date modifiedDatetime;

    @Column(nullable = false)
    private Long modifiedBy;
}
