package com.example.letsreviewserver.country.district;

import com.example.letsreviewserver.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByProvince_ProvinceId(Long provinceId);
}
