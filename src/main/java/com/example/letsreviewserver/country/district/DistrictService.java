package com.example.letsreviewserver.country.district;

import com.example.letsreviewserver.auth.AuthUtil;
import com.example.letsreviewserver.country.province.ProvinceRepository;
import com.example.letsreviewserver.dto.district.CreateDistrictRequest;
import com.example.letsreviewserver.model.District;
import com.example.letsreviewserver.model.Province;
import com.example.letsreviewserver.model.User;
import com.example.letsreviewserver.model.nondb.Coordinate;
import com.example.letsreviewserver.user.UserRepository;
import com.example.letsreviewserver.util.exception.DistrictNotFoundException;
import com.example.letsreviewserver.util.exception.ProvinceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;
    private final UserRepository userRepository;
    private final AuthUtil authUtil;

    public List<District> getDistrictsByProvince(Long provinceId) {
        provinceRepository.findById(provinceId).orElseThrow(() -> new ProvinceNotFoundException("Province with id " + provinceId + " not found"));
        return districtRepository.findByProvince_ProvinceId(provinceId);
    }


    public Long createDistrict(Long provinceId, CreateDistrictRequest request) {
        Province province = provinceRepository.findById(provinceId).orElseThrow(() -> new ProvinceNotFoundException("Province with id " + provinceId + " not found"));
        Long userId = 0L;

        String username = authUtil.getCurrentUsername();
        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        for (Coordinate co : request.getCoordinates()) {
            System.out.println(co.getLat() + " " +  co.getLng());
        }

        District district = new District();
        district.setDistrictName(request.getDistrictName());
        district.setCoordinates(request.getCoordinates());
        district.setProvince(province);
        district.setCreatedDatetime(new Date());
        district.setModifiedDatetime(new Date());
        district.setCreatedBy(userId);
        district.setModifiedBy(userId);

        District saved = districtRepository.save(district);
        return saved.getDistrictId();
    }

    public District getDistrictById(Long districtId) {
        return districtRepository.findById(districtId).orElseThrow(() -> new DistrictNotFoundException("District with id " + districtId + " not found"));
    }

    public District updateDistrict(Long districtId, CreateDistrictRequest request) {
        Long userId = 0L;

        String username = authUtil.getCurrentUsername();

        if (username != null) {
            userId = userRepository.findByEmail(username).map(User::getUserId).orElse(0L);
        }

        District district = getDistrictById(districtId);
        district.setDistrictName(request.getDistrictName());
        district.setCoordinates(request.getCoordinates());
        district.setModifiedDatetime(new Date());
        district.setModifiedBy(userId);

        return districtRepository.save(district);
    }

    public void deleteDistrict(Long districtId) {
        District district = getDistrictById(districtId);
        districtRepository.delete(district);
    }
}
