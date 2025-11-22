package com.example.letsreviewserver.dto.country;

import com.example.letsreviewserver.model.nondb.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCountryRequest {
    private String countryName;
    private List<Coordinate> coordinates;
}
