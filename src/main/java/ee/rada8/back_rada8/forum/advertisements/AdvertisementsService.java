package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.advertisements.Advertisement;
import ee.rada8.back_rada8.domain.advertisements.AdvertisementMapper;
import ee.rada8.back_rada8.domain.advertisements.AdvertisementService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        //leia Id järgi ad ja uuenda
        Advertisement advertisement = getEditedAdvertisement(advertisementId, advertisementDto);
        //salvesta ad
        advertisementService.saveAdvertisement(advertisement);

    }

    private Advertisement getEditedAdvertisement(Integer advertisementId, AdvertisementDto advertisementDto) {
        Advertisement advertisement = advertisementService.findAdvertisement(advertisementId);
        advertisementMapper.updateAdvertisement(advertisementDto, advertisement);
        return advertisement;
    }

    public List<AdvertisementDto> getAdvertisements(Integer userId, Integer typeId) {
        List<Advertisement> advertisements = advertisementService.findAdvertisements(userId, typeId);
        List<AdvertisementDto> advertisementDtos = advertisementMapper.toDtos(advertisements);
        return advertisementDtos;
    }
}
