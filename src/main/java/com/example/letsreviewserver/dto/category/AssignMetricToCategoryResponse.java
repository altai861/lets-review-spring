package com.example.letsreviewserver.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignMetricToCategoryResponse {
    private String message;
    private Long categoryId;
    private Long metricId;
}
