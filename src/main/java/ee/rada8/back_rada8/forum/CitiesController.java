package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.forum.advertisements.AdvertisementDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitiesController {

    @GetMapping("/cities")
    @Operation(summary = "Finds all cities", description = "Finds all cities in City table")
    public List<CityDto> getAllCities() {

    }

}
