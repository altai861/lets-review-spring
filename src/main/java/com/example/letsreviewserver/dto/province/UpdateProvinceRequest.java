package com.example.letsreviewserver.dto.province;

import com.example.letsreviewserver.model.nondb.Coordinate;
import lombok.Data;

import java.util.List;

@Data
public class UpdateProvinceRequest {
    private String provinceName;
    private List<Coordinate> coordinates;
}
