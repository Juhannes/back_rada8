package ee.rada8.back_rada8.domain.advertisements;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AdvertisementService {

    @Resource
    private AdvertisementRepository advertisementRepository;

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
        List<Advertisement> sortedAdvertisements = advertisementRepository.findActiveAdvertisements(cityId, typeId, status);
        return sortedAdvertisements;
    }
}
