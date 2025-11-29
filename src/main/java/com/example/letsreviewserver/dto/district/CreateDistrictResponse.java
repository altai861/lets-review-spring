package com.example.letsreviewserver.dto.district;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDistrictResponse {
    private String message;
    private Long districtId;
}
