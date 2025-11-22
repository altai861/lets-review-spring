package com.example.letsreviewserver.admin.country;

import com.example.letsreviewserver.dto.country.CreateCountryRequest;
import com.example.letsreviewserver.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public Country createCountry(@RequestBody CreateCountryRequest createCountryRequest) {
        return countryService.createCountry(createCountryRequest);
    }
}
