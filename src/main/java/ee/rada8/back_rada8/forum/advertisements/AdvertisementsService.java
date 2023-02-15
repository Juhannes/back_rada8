package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.City;
import ee.rada8.back_rada8.domain.CityService;
import ee.rada8.back_rada8.domain.advertisements.Advertisement;
import ee.rada8.back_rada8.domain.advertisements.AdvertisementMapper;
import ee.rada8.back_rada8.domain.advertisements.AdvertisementService;
import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementType;
import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementTypeService;
import ee.rada8.back_rada8.forum.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static ee.rada8.back_rada8.forum.Status.DELETED;

@Service
public class AdvertisementsService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Resource
    private AdvertisementService advertisementService;
    @Resource
    private AdvertisementTypeService advertisementTypeService;
    @Resource
    private CityService cityService;

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

    public Advertisement getEditedAdvertisement(Integer advertisementId, AdvertisementDto advertisementDto) {
        Advertisement advertisement = advertisementService.findAdvertisement(advertisementId);
        advertisementMapper.updateAdvertisement(advertisementDto, advertisement);
        updateCityIfChanged(advertisementDto.getCityId(), advertisement);
        updateTypeIfChanged(advertisementDto.getTypeId(), advertisement);
        return advertisement;
    }

    private void updateTypeIfChanged(Integer dtoTypeId, Advertisement advertisement) {
        if (!dtoTypeId.equals(advertisement.getType().getId())) {
            AdvertisementType advertisementType = advertisementTypeService.findAdvertisementType(dtoTypeId);
            advertisement.setType(advertisementType);
        }
    }

    private void updateCityIfChanged(Integer dtoCityId, Advertisement advertisement) {
        if (!dtoCityId.equals(advertisement.getCity().getId())) {
            City city = cityService.findCity(dtoCityId);
            advertisement.setCity(city);
        }
    }

    public List<AdvertisementDto> getAdvertisements(Integer userId, Integer typeId) {
        List<Advertisement> advertisements = advertisementService.findAdvertisements(userId, typeId);
        List<AdvertisementDto> advertisementDtos = advertisementMapper.toDtos(advertisements);
        return advertisementDtos;
    }

    public void deleteAdvertisement(Integer advertisementId) {
        //leiab advertisementi
        Advertisement advertisement = advertisementService.findAdvertisement(advertisementId);
        //leiab pealkirja ja lisab pealkirjale "deleted" + timestamp
        String currentHeader = advertisement.getHeader();
        //salvestab pealkirja
        String newHeader = currentHeader + " (deleted: " + LocalDateTime.now() + ")";
        advertisement.setHeader(newHeader);
        //määrab staatuseks deactivated
        advertisement.setStatus(DELETED);
        //salvestab advertisementi
        advertisementService.saveAdvertisement(advertisement);
    }

    public AdvertisementResponse getAdvertisement(Integer advertisementId) {
        Advertisement advertisement = advertisementService.findAdvertisement(advertisementId);
        return advertisementMapper.toResponse(advertisement);
    }
    public List<AdvertisementDto> getAllAdvertisements() {
        List<Advertisement> allAdvertisements = advertisementService.findAllAdvertisements();
        List<AdvertisementDto> advertisementDtos = advertisementMapper.toDtos(allAdvertisements);
        return advertisementDtos;
    }
}
