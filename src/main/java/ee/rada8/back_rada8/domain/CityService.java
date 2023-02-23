package ee.rada8.back_rada8.domain;

import ee.rada8.back_rada8.forum.CityDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CityService {
    @Resource
    private CityRepository cityRepository;
    @Resource
    private CityMapper cityMapper;
    //ühendus repoga, saa sealt entity
    public List<CityDto> findCities() {
        List<City> cities = cityRepository.findAll();
        List<City> sortedCities = cities.stream().sorted(Comparator.comparing((City::getName))).toList();
        return cityMapper.toDtos(sortedCities);
    }

    public City findCity(Integer cityId) {
        return cityRepository.findById(cityId).get();
    }
}
