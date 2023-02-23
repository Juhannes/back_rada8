package ee.rada8.back_rada8.forum.login;

import ee.rada8.back_rada8.domain.CityService;
import ee.rada8.back_rada8.forum.CityDto;
import ee.rada8.back_rada8.forum.advertisements.AdvertisementsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {
    @Resource
    private CityService cityService;

    @Resource
    private AdvertisementsService advertisementsService;
    public List<CityDto> getCities() {
        return cityService.findCities();
    }

    public List<CityDto> getActiveAdCities() {
        return advertisementsService.getActiveAdCities();
    }
}
