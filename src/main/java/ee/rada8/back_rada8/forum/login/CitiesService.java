package ee.rada8.back_rada8.forum.login;

import ee.rada8.back_rada8.domain.City;
import ee.rada8.back_rada8.domain.CityMapper;
import ee.rada8.back_rada8.domain.CityService;
import ee.rada8.back_rada8.forum.CityDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {
    @Resource
    private CityMapper cityMapper;
    @Resource
    private CityService cityService;
    public List<CityDto> getCities() {
        return cityService.findCities();
    }

    public CityDto getCity(Integer cityId) {
        City city = cityService.findCity(cityId);
        CityDto cityDto = cityMapper.toDto(city);
        return cityDto;
    }
}
