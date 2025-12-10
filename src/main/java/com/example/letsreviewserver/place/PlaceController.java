package com.example.letsreviewserver.place;

import com.example.letsreviewserver.dto.place.PlaceRequestDTO;
import com.example.letsreviewserver.dto.place.PlaceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<List<PlaceResponseDTO>> getPlaces(
            @RequestParam(required = false) Long countryId,
            @RequestParam(required = false) Long provinceId,
            @RequestParam(required = false) Long districtId
    ) {
        List<PlaceResponseDTO> places = placeService.getFilteredPlaces(countryId, provinceId, districtId);

        return ResponseEntity.ok(places);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addPlace(@RequestBody PlaceRequestDTO request) {
        Long newPlaceId = placeService.createPlace(request);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Place added successfully");
        response.put("placeId", newPlaceId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceResponseDTO> getOnePlace(@PathVariable("id") Long id) {
        PlaceResponseDTO place = placeService.getPlaceById(id);
        return ResponseEntity.ok(place);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceResponseDTO> updatePlace(
            @PathVariable("id") Long id,
            @RequestBody PlaceRequestDTO request) {

        PlaceResponseDTO updatedPlace = placeService.updatePlace(id, request);
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePlace(@PathVariable("id") Long id) {
        placeService.deletePlace(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Place deleted successfully");

        return ResponseEntity.ok(response);
    }
}
