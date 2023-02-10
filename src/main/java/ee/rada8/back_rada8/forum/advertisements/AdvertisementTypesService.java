package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementType;
import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementTypeMapper;
import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementTypesService {
    @Resource
    private AdvertisementTypeService advertisementTypeService;
    @Resource
    private AdvertisementTypeMapper advertisementTypeMapper;
    public List<AdvertisementTypeDto> getAdvertisementTypes() {
        List<AdvertisementType> allAdvertisementTypes = advertisementTypeService.findAllAdvertisementTypes();
        return advertisementTypeMapper.toDtos(allAdvertisementTypes);
    }
}
