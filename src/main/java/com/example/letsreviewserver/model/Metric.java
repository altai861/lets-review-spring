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
@Table(name = "metric")
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metricId;

    @Column(unique = true, nullable = false)
    private String metricName;

    @Column(nullable = false)
    private String metricDescription;

    @Column(nullable = false)
    private Integer minValue;
    @Column(nullable = false)
    private Integer maxValue;

    @Column(nullable = false)
    private Date createdDatetime;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Date modifiedDatetime;

    @Column(nullable = false)
    private Long modifiedBy;
}
