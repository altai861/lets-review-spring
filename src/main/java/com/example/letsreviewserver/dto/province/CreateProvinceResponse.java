package com.example.letsreviewserver.dto.province;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProvinceResponse {
    private String message;
    private Long provinceId;
}
