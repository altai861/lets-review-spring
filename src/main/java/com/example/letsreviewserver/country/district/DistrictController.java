package com.example.letsreviewserver.country.district;

import com.example.letsreviewserver.dto.district.CreateDistrictRequest;
import com.example.letsreviewserver.dto.district.DistrictResponse;
import com.example.letsreviewserver.dto.province.CreateProvinceRequest;
import com.example.letsreviewserver.dto.province.ProvinceResponse;
import com.example.letsreviewserver.dto.province.UpdateProvinceRequest;
import com.example.letsreviewserver.model.District;
import com.example.letsreviewserver.model.Province;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/districts")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/{id}")
    public ResponseEntity<DistrictResponse> getDistrict(@PathVariable Long id){
        District district = districtService.getDistrictById(id);
        DistrictResponse districtResponse = DistrictResponse.fromEntity(district);
        return ResponseEntity.ok(districtResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictResponse> updateProvince(
            @PathVariable Long id,
            @RequestBody CreateDistrictRequest request
    ) {
        District updated = districtService.updateDistrict(id, request);
        DistrictResponse response = DistrictResponse.fromEntity(updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
        return ResponseEntity.ok(Map.of("message", "Province deleted successfully"));
    }
}
