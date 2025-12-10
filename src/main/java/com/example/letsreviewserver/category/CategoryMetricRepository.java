package com.example.letsreviewserver.category;

import com.example.letsreviewserver.model.composite.CategoryMetric;
import com.example.letsreviewserver.model.composite.CategoryMetricId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryMetricRepository extends JpaRepository<CategoryMetric, CategoryMetricId> {
    List<CategoryMetric> findByCategory_CategoryId(Long categoryId);
    List<CategoryMetric> findByMetric_MetricId(Long metricId);
}
