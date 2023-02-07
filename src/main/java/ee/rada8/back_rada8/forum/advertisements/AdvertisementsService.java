package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.advertisements.Advertisement;
import ee.rada8.back_rada8.domain.advertisements.AdvertisementMapper;
import ee.rada8.back_rada8.domain.advertisements.AdvertisementService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertisementsService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Resource
    private AdvertisementService advertisementService;

    @Transactional
    public void addAdvertisement(AdvertisementDto advertisementDto) {
        Advertisement advertisement = advertisementMapper.toEntity(advertisementDto);
        advertisementService.saveAdvertisement(advertisement);
    }

    public void editAdvertisement(Integer advertisementId, AdvertisementDto advertisementDto) {

    }
}
