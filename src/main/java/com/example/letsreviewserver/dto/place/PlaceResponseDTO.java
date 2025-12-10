package com.example.letsreviewserver.dto.place;

import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PlaceResponseDTO {
    private Long placeId;
    private String placeName;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;
    private Integer floorNumber;

    private Long districtId;
    private Long provinceId;
    private Long countryId;

    private List<MediaResponseDTO> mediaList;

    private Date createdDatetime;
    private Long createdBy;
    private Date modifiedDatetime;
    private Long modifiedBy;
}
