package com.example.letsreviewserver.model.composite;

import com.example.letsreviewserver.model.Category;
import com.example.letsreviewserver.model.Metric;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_metric")
public class CategoryMetric {

    @EmbeddedId
    private CategoryMetricId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("metricId")
    @JoinColumn(name = "metric_id")
    private Metric metric;

    @Column(nullable = false)
    private Date createdDatetime;

    @Column(nullable = false)
    private Long createdBy;

    @Column(nullable = false)
    private Date modifiedDatetime;

    @Column(nullable = false)
    private Long modifiedBy;
}
