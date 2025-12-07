package com.example.letsreviewserver.dto.business;

import com.example.letsreviewserver.dto.category.CategoryResponse;
import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import com.example.letsreviewserver.model.Category;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class BusinessResponseDTO {
    private Long businessId;
    private String businessName;
    private String status;
    private String workingHours;
    private String address;
    private Double latitude;
    private Double longitude;
    private String email;
    private Integer floorNumber;
    private LocalDateTime createdDatetime;
    private Long createdBy;
    private LocalDateTime modifiedDatetime;
    private Long modifiedBy;

    private Long userId;

    private Long districtId;
    private String districtName;
    private Long provinceId;
    private String provinceName;
    private Long countryId;
    private String countryName;

    private Long placeId;
    private String placeName;

    private List<MediaResponseDTO> media;
    private List<CategoryResponse> categories;
}
