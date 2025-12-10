package com.example.letsreviewserver.dto.province;

import com.example.letsreviewserver.model.Province;
import com.example.letsreviewserver.model.nondb.Coordinate;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProvinceResponse {
    private Long provinceId;
    private Long countryId;
    private String provinceName;
    private List<Coordinate> coordinates;
    private Date createdDatetime;
    private Long createdBy;
    private Date modifiedDatetime;
    private Long modifiedBy;

    public static ProvinceResponse fromEntity(Province province) {
        ProvinceResponse response = new ProvinceResponse();
        response.setProvinceId(province.getProvinceId());
        response.setCountryId(province.getCountry().getCountryId());
        response.setProvinceName(province.getProvinceName());
        response.setCoordinates(province.getCoordinates());
        response.setCreatedDatetime(province.getCreatedDatetime());
        response.setCreatedBy(province.getCreatedBy());
        response.setModifiedDatetime(province.getModifiedDatetime());
        response.setModifiedBy(province.getModifiedBy());

        return response;
    }
}
