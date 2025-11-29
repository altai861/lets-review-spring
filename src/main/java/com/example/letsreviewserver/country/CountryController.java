package com.example.letsreviewserver.country;

import com.example.letsreviewserver.country.province.ProvinceService;
import com.example.letsreviewserver.dto.country.CreateCountryRequest;
import com.example.letsreviewserver.dto.country.CreateCountryResponse;
import com.example.letsreviewserver.dto.province.CreateProvinceRequest;
import com.example.letsreviewserver.dto.province.CreateProvinceResponse;
import com.example.letsreviewserver.dto.province.ProvinceResponse;
import com.example.letsreviewserver.model.Country;
import com.example.letsreviewserver.model.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    private final ProvinceService provinceService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public ResponseEntity<CreateCountryResponse> createCountry(@RequestBody CreateCountryRequest createCountryRequest) {
        CreateCountryResponse createCountryResponse = countryService.createCountry(createCountryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCountryResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        return ResponseEntity.ok().body(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(
            @PathVariable Long id,
            @RequestBody CreateCountryRequest request
    ) {
        Country updated = countryService.updateCountry(id, request);
        return ResponseEntity.ok().body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok(
                Map.of("message", "Country deleted successfully")
        );
    }

    @GetMapping("/{countryId}/provinces")
    public ResponseEntity<List<ProvinceResponse>> getProvincesByCountry(@PathVariable Long countryId) {
        List<Province> provinces = provinceService.getProvincesByCountry(countryId);

        List<ProvinceResponse> responseList = provinces.stream()
                .map(ProvinceResponse::fromEntity)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{countryId}/provinces")
    public ResponseEntity<CreateProvinceResponse> createProvince(
            @PathVariable Long countryId,
            @RequestBody CreateProvinceRequest request
    ) {
        Long createdProvinceId = provinceService.createProvince(countryId, request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CreateProvinceResponse("Province successfully created", createdProvinceId));
    }
}
