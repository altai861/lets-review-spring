package com.example.letsreviewserver.dto.category;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryMetricResponse {
    private Long categoryId;
    private Long metricId;
    private String metricName;
    private String metricDescription;
    private Integer minValue;
    private Integer maxValue;
    private String createdDatetime;
    private Long createdBy;
}
