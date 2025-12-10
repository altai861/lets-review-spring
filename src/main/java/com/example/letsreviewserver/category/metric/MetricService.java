package com.example.letsreviewserver.category.metric;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.dto.metric.CreateMetricRequest;
import com.example.letsreviewserver.model.Metric;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricService {
    private final MetricRepository metricRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    public List<Metric> getAllMetrics() {
        return metricRepository.findAll();
    }

    public Long addMetric(CreateMetricRequest request) {
        Long userId = 0L;

        Date now = new Date();
        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        Metric metric = Metric.builder()
                .metricName(request.getMetricName())
                .metricDescription(request.getMetricDescription())
                .minValue(request.getMinValue())
                .maxValue(request.getMaxValue())
                .createdDatetime(now)
                .createdBy(userId)
                .modifiedDatetime(now)
                .modifiedBy(userId)
                .build();

        Metric saved = metricRepository.save(metric);
        return saved.getMetricId();
    }

    public Metric getMetricById(@PathVariable Long id) {
        return metricRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Metric not found with ID " + id));
    }

    public Metric updateMetric(@PathVariable Long id, @RequestBody CreateMetricRequest request) {
        Metric existingMetric = metricRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Metric not found with ID " + id));

        Date now = new Date();
        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        existingMetric.setMetricName(request.getMetricName());
        existingMetric.setMetricDescription(request.getMetricDescription());
        existingMetric.setMinValue(request.getMinValue());
        existingMetric.setMaxValue(request.getMaxValue());
        existingMetric.setCreatedDatetime(now);
        existingMetric.setCreatedBy(userId);
        existingMetric.setModifiedDatetime(now);
        existingMetric.setModifiedBy(userId);

        return metricRepository.save(existingMetric);
    }

    public void deleteMetric(@PathVariable Long id) {
        if (!metricRepository.existsById(id)) {
            throw new ResourceNotFoundException("Metric not found with ID " + id);
        }
        metricRepository.deleteById(id);
    }
}
