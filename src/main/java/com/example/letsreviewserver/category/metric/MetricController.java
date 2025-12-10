package com.example.letsreviewserver.category.metric;

import com.example.letsreviewserver.dto.metric.CreateMetricRequest;
import com.example.letsreviewserver.dto.metric.CreateMetricResponse;
import com.example.letsreviewserver.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/metrics")
public class MetricController {
    private final MetricService metricService;

    @GetMapping
    public ResponseEntity<List<Metric>> getMetrics() {
        List<Metric> metrics = metricService.getAllMetrics();

        return ResponseEntity.ok(metrics);
    }

    @PostMapping
    public ResponseEntity<CreateMetricResponse> createMetric(@RequestBody CreateMetricRequest request) {
        Long newMetricId = metricService.addMetric(request);
        CreateMetricResponse response = new CreateMetricResponse();
        response.setMetricId(newMetricId);
        response.setMessage("Metric created successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metric> getMetric(@PathVariable Long id) {
        Metric metric = metricService.getMetricById(id);
        return ResponseEntity.ok(metric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metric> updateMetric(@PathVariable Long id, @RequestBody CreateMetricRequest request) {
        Metric metric = metricService.updateMetric(id, request);
        return ResponseEntity.ok(metric);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMetric(@PathVariable Long id) {
        metricService.deleteMetric(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "metric deleted");
        return ResponseEntity.ok().body(response);
    }
}
