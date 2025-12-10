package com.example.letsreviewserver.dto.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCountryResponse {
    private String message;
    private Long countryId;
}
