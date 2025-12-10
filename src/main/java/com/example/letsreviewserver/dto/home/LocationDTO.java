package com.example.letsreviewserver.dto.home;

import lombok.Data;
import lombok.AllArgsConstructor; // Add this import
import lombok.NoArgsConstructor; // Recommended for DTOs

@Data
@NoArgsConstructor // Recommended
@AllArgsConstructor // Add this annotation for the constructor
public class LocationDTO {
    private String locationName;
    private LocationType type;
    private Long countryId;
    private Long provinceId;
    private Long districtId;
}