package ee.rada8.back_rada8.domain.advertisements;

import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementTypeRepository;
import ee.rada8.back_rada8.domain.City;
import ee.rada8.back_rada8.forum.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {

    @Resource
    private AdvertisementRepository advertisementRepository;
    private final AdvertisementTypeRepository advertisementTypeRepository;

    public AdvertisementService(AdvertisementTypeRepository advertisementTypeRepository) {
        this.advertisementTypeRepository = advertisementTypeRepository;
    }

    public void saveAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    public Advertisement findAdvertisement(Integer advertisementId) {
        return advertisementRepository.findById(advertisementId).get();
    }

    public List<Advertisement> findAdvertisements(Integer userId, Integer typeId) {
        return advertisementRepository.findByUserIdAndTypeId(userId, typeId);
    }

    public List<Advertisement> findAllActiveAdvertisements(String status) {
        List<Advertisement> allActiveAdvertisements = advertisementRepository.findAllActiveAdvertisements(status);
        return allActiveAdvertisements;
    }

    public List<Advertisement> getSortedAdvertisements(Integer cityId, Integer typeId, String status) {
        if (cityId == 0 && typeId == 0) {
            return findAllActiveAdvertisements(status);
        } else if (cityId == 0 && typeId != 0) {
            return advertisementRepository.findByTypeIdAndStatus(typeId, status);
        } else if (cityId != 0 && typeId == 0) {
            return advertisementRepository.findByCityIdAndStatus(cityId, status);
        } else {
            List<Advertisement> sortedAdvertisements = advertisementRepository.findActiveAdvertisements(cityId, typeId, status);
            return sortedAdvertisements;
        }
    }

    public List<City> getActiveAdCities() {
        List<Advertisement> allActiveAdvertisements = advertisementRepository.findAllActiveAdvertisements(Status.ACTIVE);

        HashSet<City> citiesHashSet = new LinkedHashSet<>();

        for (Advertisement activeAdvertisement : allActiveAdvertisements) {
            if (!citiesHashSet.contains(activeAdvertisement.getCity())) {
                citiesHashSet.add(activeAdvertisement.getCity());
            }
        }

        List<City> sortedCities = citiesHashSet.stream().sorted(Comparator.comparing((City::getName))).collect(Collectors.toList());

        return sortedCities;


    }
}
