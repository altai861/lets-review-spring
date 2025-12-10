package com.example.letsreviewserver.country.province;

import com.example.letsreviewserver.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    List<Province> findByCountry_CountryId(Long countryId);
}
