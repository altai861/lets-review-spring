package com.example.letsreviewserver.category;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.category.metric.MetricRepository;
import com.example.letsreviewserver.dto.category.AssignMetricToCategoryResponse;
import com.example.letsreviewserver.dto.category.CategoryMetricResponse;
import com.example.letsreviewserver.model.Category;
import com.example.letsreviewserver.model.Metric;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.model.composite.CategoryMetric;
import com.example.letsreviewserver.model.composite.CategoryMetricId;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryMetricService {
    private final CategoryMetricRepository categoryMetricRepository;
    private final CategoryRepository categoryRepository;
    private final MetricRepository metricRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    public AssignMetricToCategoryResponse assignMetric(Long categoryId, Long metricId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Metric metric = metricRepository.findById(metricId)
                .orElseThrow(() -> new ResourceNotFoundException("Metric not found"));

        Long userId = getCurrentUserId();

        CategoryMetricId id = new CategoryMetricId(categoryId, metricId);

        CategoryMetric cm = new CategoryMetric();
        cm.setId(id);
        cm.setCategory(category);
        cm.setMetric(metric);
        cm.setCreatedDatetime(new Date());
        cm.setModifiedDatetime(new Date());
        cm.setCreatedBy(userId);
        cm.setModifiedBy(userId);

        categoryMetricRepository.save(cm);

        return new AssignMetricToCategoryResponse(
                "Metric assigned to category",
                categoryId,
                metricId
        );
    }

    public List<CategoryMetricResponse> getMetricsOfCategory(Long categoryId) {
        List<CategoryMetric> list = categoryMetricRepository.findByCategory_CategoryId(categoryId);

        return list.stream().map(cm -> {
            CategoryMetricResponse res = new CategoryMetricResponse();
            res.setCategoryId(cm.getCategory().getCategoryId());
            res.setMetricId(cm.getMetric().getMetricId());
            res.setMetricName(cm.getMetric().getMetricName());
            res.setMetricDescription(cm.getMetric().getMetricDescription());
            res.setMinValue(cm.getMetric().getMinValue());
            res.setMaxValue(cm.getMetric().getMaxValue());
            res.setCreatedDatetime(cm.getCreatedDatetime().toString());
            res.setCreatedBy(cm.getCreatedBy());
            return res;
        }).toList();
    }

    public void removeMetricFromCategory(Long categoryId, Long metricId) {
        CategoryMetricId id = new CategoryMetricId(categoryId, metricId);

        CategoryMetric cm = categoryMetricRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relation not found"));

        categoryMetricRepository.delete(cm);
    }

    private Long getCurrentUserId() {
        String username = authUtil.getCurrentUsername();
        return username == null
                ? 0L
                : userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
    }
}
