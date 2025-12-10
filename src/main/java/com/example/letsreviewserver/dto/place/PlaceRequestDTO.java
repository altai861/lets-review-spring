package com.example.letsreviewserver.dto.place;

import lombok.Data;

import java.util.List;

@Data
public class PlaceRequestDTO {
    private String placeName;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer floorNumber;
    private Long districtId;
    private List<Long> mediaIds;
}
