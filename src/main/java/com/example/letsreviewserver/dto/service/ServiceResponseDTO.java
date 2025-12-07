package com.example.letsreviewserver.dto.service;

import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ServiceResponseDTO {
    private Long serviceId;
    private String serviceName;
    private Double price;
    private String description;
    private Long availability;
    private Long businessId;

    private List<MediaResponseDTO> media;

    private LocalDateTime createdDatetime;
    private Long createdBy;
    private LocalDateTime modifiedDatetime;
    private Long modifiedBy;
}
