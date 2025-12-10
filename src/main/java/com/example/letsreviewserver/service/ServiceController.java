package com.example.letsreviewserver.service;

import com.example.letsreviewserver.dto.service.CreateServiceRequest;
import com.example.letsreviewserver.dto.service.ServiceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> getBusinessService(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> updateService(@PathVariable("id") Long id, @RequestBody CreateServiceRequest createServiceRequest) {
        return ResponseEntity.ok(serviceService.updateService(id, createServiceRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") Long id) {
        serviceService.deleteService(id);

        Map<String, String> response = Collections.singletonMap(
                "message",
                "Service got deleted successfully"
        );

        return ResponseEntity.ok(response);
    }
}
