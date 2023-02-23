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

    @GetMapping("/cities-ads")
    @Operation(summary = "Finds cities that have ad(s) posted in them", description = "Finds all unique cities from Advertisement table that have ad posted")
    public List<CityDto> getActiveAdCities() {
        return citiesService.getActiveAdCities();
    }
}
