package com.example.letsreviewserver.country.province;

import com.example.letsreviewserver.country.district.DistrictService;
import com.example.letsreviewserver.dto.district.CreateDistrictRequest;
import com.example.letsreviewserver.dto.district.CreateDistrictResponse;
import com.example.letsreviewserver.dto.district.DistrictResponse;
import com.example.letsreviewserver.dto.province.ProvinceResponse;
import com.example.letsreviewserver.dto.province.UpdateProvinceRequest;
import com.example.letsreviewserver.model.District;
import com.example.letsreviewserver.model.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/provinces")
@RequiredArgsConstructor
public class ProvinceController {
    private final ProvinceService provinceService;
    private final DistrictService districtService;

    @GetMapping("/{id}")
    public ResponseEntity<ProvinceResponse> getProvinceById(@PathVariable Long id) {
        Province province = provinceService.getProvinceById(id);
        ProvinceResponse response = ProvinceResponse.fromEntity(province);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvinceResponse> updateProvince(
            @PathVariable Long id,
            @RequestBody UpdateProvinceRequest request
    ) {
        Province updated = provinceService.updateProvince(id, request);
        ProvinceResponse response = ProvinceResponse.fromEntity(updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
        return ResponseEntity.ok(Map.of("message", "Province deleted successfully"));
    }

    @GetMapping("/{provinceId}/districts")
    public ResponseEntity<List<DistrictResponse>> getDistrictsByProvince(@PathVariable Long provinceId) {
        List<District> districts = districtService.getDistrictsByProvince(provinceId);

        List<DistrictResponse> responseList = districts.stream()
                .map(DistrictResponse::fromEntity)
                .toList();

        return ResponseEntity.ok(responseList);
    }

    @PostMapping("/{provinceId}/districts")
    public ResponseEntity<CreateDistrictResponse> createDistrict(
            @PathVariable Long provinceId,
            @RequestBody CreateDistrictRequest request
    ) {
        Long createdDistrictId = districtService.createDistrict(provinceId, request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CreateDistrictResponse("District successfully created", createdDistrictId));
    }
}
