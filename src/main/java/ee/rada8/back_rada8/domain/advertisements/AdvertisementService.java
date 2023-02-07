package ee.rada8.back_rada8.domain.advertisements;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {


    private AdvertisementRepository advertisementRepository;

    public void saveAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }
}
