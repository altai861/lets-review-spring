package com.example.letsreviewserver.dto.district;

import com.example.letsreviewserver.model.District;
import com.example.letsreviewserver.model.nondb.Coordinate;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DistrictResponse {
    private Long districtId;
    private Long provinceId;
    private String districtName;
    private List<Coordinate> coordinates;
    private Date createdDatetime;
    private Long createdBy;
    private Date modifiedDatetime;
    private Long modifiedBy;

    public static DistrictResponse fromEntity(District district) {
        DistrictResponse districtResponse = new DistrictResponse();
        districtResponse.setCoordinates(district.getCoordinates());
        districtResponse.setDistrictId(district.getDistrictId());
        districtResponse.setProvinceId(district.getProvince().getProvinceId());
        districtResponse.setDistrictName(district.getDistrictName());
        districtResponse.setCreatedDatetime(district.getCreatedDatetime());
        districtResponse.setCreatedBy(district.getCreatedBy());
        districtResponse.setModifiedDatetime(district.getModifiedDatetime());
        districtResponse.setModifiedBy(district.getModifiedBy());

        return districtResponse;
    }
}
