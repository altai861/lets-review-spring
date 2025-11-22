package com.example.letsreviewserver.admin.country;

import com.example.letsreviewserver.dto.country.CreateCountryRequest;
import com.example.letsreviewserver.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country createCountry(CreateCountryRequest createCountryRequest) {
        Country country = Country.builder()
                .countryName(createCountryRequest.getCountryName())
                .coordinates(createCountryRequest.getCoordinates())
                .createdDatetime(new Date())
                .createdBy(0L)
                .modifiedDatetime(new Date())
                .modifiedBy(0L)
                .build();
        return countryRepository.save(country);
    }
}
