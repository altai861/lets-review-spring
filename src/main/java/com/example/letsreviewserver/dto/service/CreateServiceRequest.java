package com.example.letsreviewserver.dto.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceRequest {
    private String serviceName;
    private Double price;
    private String description;
    private Long availability;
    private List<Long> mediaIds;
}
