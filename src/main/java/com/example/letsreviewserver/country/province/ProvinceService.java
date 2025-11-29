package com.example.letsreviewserver.country.province;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.country.CountryRepository;
import com.example.letsreviewserver.dto.province.CreateProvinceRequest;
import com.example.letsreviewserver.dto.province.UpdateProvinceRequest;
import com.example.letsreviewserver.model.Country;
import com.example.letsreviewserver.model.Province;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.CountryNotFoundException;
import com.example.letsreviewserver.util.exception.ProvinceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final CountryRepository countryRepository;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;

    public List<Province> getProvincesByCountry(Long countryId) {
        countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException("Country with id " + countryId + " not found"));

        return provinceRepository.findByCountry_CountryId(countryId);
    }

    public Long createProvince(Long countryId, CreateProvinceRequest request) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException("Country with id " + countryId + " not found"));

        Long userId = 0L;

        String username = authUtil.getCurrentUsername();
        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        Province province = new Province();
        province.setProvinceName(request.getProvinceName());
        province.setCoordinates(request.getCoordinates());
        province.setCountry(country);
        province.setCreatedDatetime(new Date());
        province.setModifiedDatetime(new Date());
        province.setCreatedBy(userId);
        province.setModifiedBy(userId);

        Province saved = provinceRepository.save(province);
        return saved.getProvinceId();
    }

    public Province getProvinceById(Long id) {
        return provinceRepository.findById(id).orElseThrow(() -> new ProvinceNotFoundException("Province with id " + id + " not found"));
    }

    public Province updateProvince(Long id, UpdateProvinceRequest request) {
        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        Province province = getProvinceById(id);
        province.setProvinceName(request.getProvinceName());
        province.setCoordinates(request.getCoordinates());
        province.setModifiedDatetime(new Date());
        province.setModifiedBy(userId);

        return provinceRepository.save(province);
    }

    public void deleteProvince(Long id) {
        Province province = getProvinceById(id);
        provinceRepository.delete(province);
    }
}
