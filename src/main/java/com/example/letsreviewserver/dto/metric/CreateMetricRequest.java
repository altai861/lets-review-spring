package com.example.letsreviewserver.dto.metric;

import lombok.Data;

@Data
public class CreateMetricRequest {
    private String metricName;
    private String metricDescription;
    private Integer minValue;
    private Integer maxValue;
}
