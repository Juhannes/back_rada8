package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.advertisements.Advertisement;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertisementsController {

    @Resource
    private AdvertisementsService advertisementsService;

    @PostMapping("/my-advertisements")
    @Operation(summary = "Adds new advertisement", description = "Adds new advertisement to table 'advertisement'")
    public void addAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        advertisementsService.addAdvertisement(advertisementDto);
    }

    @PutMapping("/my-advertisements")
    @Operation(summary = "Modifies existing advertisement", description = "Modifies an advertisement in table 'advertisement', finds by advertisementId")
    public void editAdvertisement(@RequestParam Integer advertisementId, @RequestBody AdvertisementDto advertisementDto) {
        advertisementsService.editAdvertisement(advertisementId, advertisementDto);
    }

    @GetMapping("/my-advertisements")
    @Operation(summary = "Returns advertisements", description = "Returns advertisements by userId and typeId")
    public List<AdvertisementDto> getAdvertisements(@RequestParam Integer userId, @RequestParam Integer typeId) {
        List<AdvertisementDto> advertisements = advertisementsService.getAdvertisements(userId, typeId);
        return advertisements;
    }

    @DeleteMapping("/my-advertisements")
    @Operation(summary = "Deletes an advertisement", description = "Deletes advertisement by advertisementId")
    public void deleteAdvertisement(@RequestParam Integer advertisementId) {
        advertisementsService.deleteAdvertisement(advertisementId);
    }
}
