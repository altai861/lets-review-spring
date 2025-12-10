package com.example.letsreviewserver.dto.district;

import com.example.letsreviewserver.model.nondb.Coordinate;
import lombok.Data;

import java.util.List;

@Data
public class CreateDistrictRequest {
    private String districtName;
    private List<Coordinate> coordinates;
}
