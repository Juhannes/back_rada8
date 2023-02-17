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
        List<Advertisement> advertisement = advertisementRepository.findByUserIdAndTypeId(userId, typeId);
        return advertisement;
    }

    public List<Advertisement> findAllAdvertisements() {
        List<Advertisement> allAdvertisements = advertisementRepository.findAll();
        return allAdvertisements;
    }
}
