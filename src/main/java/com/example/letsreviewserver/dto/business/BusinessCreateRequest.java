package com.example.letsreviewserver.dto.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessCreateRequest {
    private String businessName;
    private String workingHours;
    private String address;
    private Double latitude;
    private Double longitude;
    private String email;
    private Long districtId;
    private List<Long> mediaIds;
    private List<Long> categoryIds;
    private Long placeId;
    private Integer floorNumber;
}
