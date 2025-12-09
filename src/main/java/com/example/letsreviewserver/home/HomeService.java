package com.example.letsreviewserver.home;

import com.example.letsreviewserver.country.CountryRepository;
import com.example.letsreviewserver.country.district.DistrictRepository;
import com.example.letsreviewserver.country.province.ProvinceRepository;
import com.example.letsreviewserver.dto.home.LocationDTO;
import com.example.letsreviewserver.dto.home.LocationType;
import com.example.letsreviewserver.model.Country;
import com.example.letsreviewserver.model.District;
import com.example.letsreviewserver.model.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final CountryRepository countryRepository;
    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;

    public List<LocationDTO> getAllLocations() {
        // 1. Fetch all entities
        List<Country> countries = countryRepository.findAll();
        List<Province> provinces = provinceRepository.findAll();
        List<District> districts = districtRepository.findAll();

        // 2. Map to LocationDTO using Java Streams
        List<LocationDTO> countryLocations = countries.stream()
                .map(country -> new LocationDTO(
                        country.getCountryName(),
                        LocationType.COUNTRY,
                        country.getCountryId(),
                        null,
                        null)
                ).collect(Collectors.toList());

        List<LocationDTO> provinceLocations = provinces.stream()
                .map(province -> new LocationDTO(
                        province.getProvinceName(),
                        LocationType.PROVINCE,
                        province.getCountry().getCountryId(), // Assuming Province has a Country relationship
                        province.getProvinceId(),
                        null)
                ).collect(Collectors.toList());

        List<LocationDTO> districtLocations = districts.stream()
                .map(district -> new LocationDTO(
                        district.getDistrictName(),
                        LocationType.DISTRICT,
                        district.getProvince().getCountry().getCountryId(), // Assuming District has a Province relationship
                        district.getProvince().getProvinceId(),
                        district.getDistrictId())
                ).collect(Collectors.toList());

        // 3. Combine the lists
        return Stream.of(countryLocations, provinceLocations, districtLocations)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
