package com.example.letsreviewserver.business;

import com.example.letsreviewserver.dto.business.BusinessCreateRequest;
import com.example.letsreviewserver.dto.business.BusinessResponseDTO;
import com.example.letsreviewserver.dto.service.CreateServiceRequest;
import com.example.letsreviewserver.dto.service.ServiceResponseDTO;
import com.example.letsreviewserver.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/businesses")
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;
    private final ServiceService serviceService;

    @GetMapping
    public List<BusinessResponseDTO> getBusinesses(
            @RequestParam(required = false) Long countryId,
            @RequestParam(required = false) Long provinceId,
            @RequestParam(required = false) Long districtId,
            @RequestParam(required = false) Long categoryId
    ) {
        return businessService.getBusinesses(countryId, provinceId, districtId, categoryId);
    }

    @PostMapping
    public ResponseEntity<BusinessResponseDTO> createBusiness(@RequestBody BusinessCreateRequest req) {
        BusinessResponseDTO dto = businessService.createBusiness(req);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessResponseDTO> getBusiness(@PathVariable Long id) {
        return ResponseEntity.ok(businessService.getBusiness(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessResponseDTO> updateBusiness(
            @PathVariable Long id,
            @RequestBody BusinessCreateRequest req
    ) {
        return ResponseEntity.ok(businessService.updateBusiness(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return ResponseEntity.ok().body(Map.of("message", "Business removed successfully"));
    }

    // Service Endpoints
    @GetMapping("/{id}/services")
    public List<ServiceResponseDTO> getBusinessServices(@PathVariable("id") Long businessId) {
        return serviceService.getServiceByBusinessId(businessId);
    }


    @PostMapping("/{id}/services")
    public ResponseEntity<ServiceResponseDTO> createBusinessService(@PathVariable("id") Long businessId, @RequestBody CreateServiceRequest req) {
        ServiceResponseDTO dto = serviceService.createBusinessService(businessId, req);
        return ResponseEntity.ok(dto);
    }
}
