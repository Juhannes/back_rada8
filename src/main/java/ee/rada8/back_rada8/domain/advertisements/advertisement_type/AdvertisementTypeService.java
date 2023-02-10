package ee.rada8.back_rada8.domain.advertisements.advertisement_type;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementTypeService {
    @Resource
    private AdvertisementTypeRepository advertisementTypeRepository;
    public List<AdvertisementType> findAllAdvertisementTypes() {
        return advertisementTypeRepository.findAll();
    }
}
