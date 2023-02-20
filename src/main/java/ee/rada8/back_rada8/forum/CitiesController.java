package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.forum.login.CitiesService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @GetMapping("/cities")
    @Operation(summary = "Finds all cities", description = "Finds all cities in City table")
    public List<CityDto> getAllCities() {
        return citiesService.getCities();
    }

    @GetMapping("/city")
    @Operation(summary = "Finds city by cityId", description = "Finds city by cityId")
    public CityDto getCity(Integer cityId) {
        return citiesService.getCity(cityId);
    }


}
