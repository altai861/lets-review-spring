package com.example.letsreviewserver.country;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.dto.country.CreateCountryRequest;
import com.example.letsreviewserver.dto.country.CreateCountryResponse;
import com.example.letsreviewserver.model.Country;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.CountryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public CreateCountryResponse createCountry(CreateCountryRequest createCountryRequest) {

        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        Country country = Country.builder()
                .countryName(createCountryRequest.getCountryName())
                .coordinates(createCountryRequest.getCoordinates())
                .createdDatetime(new Date())
                .createdBy(userId)
                .modifiedDatetime(new Date())
                .modifiedBy(userId)
                .build();
        countryRepository.save(country);

        return new CreateCountryResponse(
                "Country created successfully",
                country.getCountryId()
        );
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException("Country not found with id: " + id));
    }

    public Country updateCountry(Long id, CreateCountryRequest request) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException("Country not found with id: " + id));

        Long userId = 0L;

        String username = authUtil.getCurrentUsername();
        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        country.setCountryName(request.getCountryName());
        country.setCoordinates(request.getCoordinates());
        country.setModifiedDatetime(new Date());
        country.setModifiedBy(userId);

        return countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException("Country not found with id: " + id));

        countryRepository.delete(country);
    }
}
