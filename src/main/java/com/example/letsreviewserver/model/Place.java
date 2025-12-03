package com.example.letsreviewserver.model;

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
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;

    @Column(unique = true, nullable = false)
    private String placeName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Integer floorNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "districtId", nullable = false)
    private District district;

    @Column(nullable = false)
    private Date createdDatetime;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Date modifiedDatetime;

    @Column(nullable = false)
    private Long modifiedBy;
}
