package com.example.letsreviewserver.util.mapper;

import com.example.letsreviewserver.dto.business.BusinessResponseDTO;
import com.example.letsreviewserver.dto.category.CategoryResponse;
import com.example.letsreviewserver.dto.media.MediaResponseDTO;
import com.example.letsreviewserver.model.Category;
import com.example.letsreviewserver.model.business.Business;
import com.example.letsreviewserver.model.business.BusinessCategory;
import com.example.letsreviewserver.model.business.BusinessMedia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BusinessMapper {
    private final MediaMapper mediaMapper;
    private final CategoryMapper categoryMapper;

    public BusinessResponseDTO toDto(Business b) {
        if (b == null) return null;

        List<MediaResponseDTO> media = b.getBusinessMediaList().stream()
                .map(BusinessMedia::getMedia)
                .map(mediaMapper::toDto)
                .collect(Collectors.toList());

        List<CategoryResponse> cats = b.getBusinessCategoryList().stream()
                .map(BusinessCategory::getCategory)
                .map(categoryMapper::toDto)
                .toList();

        Long districtId = b.getDistrict() != null ? b.getDistrict().getDistrictId() : null;
        String districtName = b.getDistrict() != null ? b.getDistrict().getDistrictName() : null;

        Long provinceId = (b.getDistrict() != null && b.getDistrict().getProvince() != null) ? b.getDistrict().getProvince().getProvinceId() : null;
        String provinceName = (b.getDistrict() != null && b.getDistrict().getProvince() != null) ? b.getDistrict().getProvince().getProvinceName() : null;

        Long countryId = (b.getDistrict() != null && b.getDistrict().getProvince() != null && b.getDistrict().getProvince().getCountry() != null) ? b.getDistrict().getProvince().getCountry().getCountryId() : null;
        String countryName = (b.getDistrict() != null && b.getDistrict().getProvince() != null && b.getDistrict().getProvince().getCountry() != null) ? b.getDistrict().getProvince().getCountry().getCountryName() : null;

        return BusinessResponseDTO.builder()
                .businessId(b.getBusinessId())
                .businessName(b.getBusinessName())
                .status(b.getStatus())
                .workingHours(b.getWorkingHours())
                .address(b.getAddress())
                .latitude(b.getLatitude())
                .longitude(b.getLongitude())
                .email(b.getEmail())
                .floorNumber(b.getFloorNumber())
                .createdDatetime(b.getCreatedDatetime())
                .createdBy(b.getCreatedBy())
                .modifiedDatetime(b.getModifiedDatetime())
                .modifiedBy(b.getModifiedBy())

                .userId(b.getUser() != null ? b.getUser().getUserId() : 0L)

                .districtId(districtId)
                .districtName(districtName)
                .provinceId(provinceId)
                .provinceName(provinceName)
                .countryId(countryId)
                .countryName(countryName)

                .placeId(b.getPlace() != null ? b.getPlace().getPlaceId() : 0L)
                .placeName(b.getPlace() != null ? b.getPlace().getPlaceName() : null)

                .media(media)
                .categories(cats)
                .build();
    }
}
