package ee.rada8.back_rada8.domain;

import ee.rada8.back_rada8.forum.CityDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
        return cityMapper.toDtos(cities);

    }
    //mapperiga entity to Dto
}
