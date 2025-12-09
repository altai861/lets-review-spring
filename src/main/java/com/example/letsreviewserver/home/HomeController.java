package com.example.letsreviewserver.home;

import com.example.letsreviewserver.dto.home.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("message", "Lets Review Server api");
    }

    @GetMapping("/api/home/locations")
    public List<LocationDTO> getLocations(){
        return homeService.getAllLocations(); // Call the service method
    }
}
