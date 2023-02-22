package ee.rada8.back_rada8.forum.advertisements;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertisementsController {

    @Resource
    private AdvertisementsService advertisementsService;
    @Resource
    private AdvertisementTypesService advertisementTypesService;

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

    @GetMapping("/advertisements")
    @Operation(summary = "Returns all active advertisements", description = "Returns all advertisements by status")
    public List<AdvertisementDto> getAllActiveAdvertisements(@RequestParam String status) {
        List<AdvertisementDto> allActiveAdvertisements = advertisementsService.getAllActiveAdvertisements(status);
        return allActiveAdvertisements;
    }

    @GetMapping("/advertisement-location-type")
    @Operation(summary = "Returns advertisements by locationId and typeID", description = "Returns advertisements by cityId and typeId")
    public List<AdvertisementDto> sortedAdvertisements(@RequestParam Integer cityId, @RequestParam Integer typeId, @RequestParam String status) {
        return advertisementsService.getSortedAdvetisements(cityId, typeId, status);
    }




    @GetMapping("/my-advertisements")
    @Operation(summary = "Returns advertisements", description = "Returns advertisements by userId and typeId")
    public List<AdvertisementDto> getAdvertisements(@RequestParam Integer userId, @RequestParam Integer typeId) {
        List<AdvertisementDto> advertisements = advertisementsService.getAdvertisements(userId, typeId);
        return advertisements;
    }

    @GetMapping("/my-advertisement")
    @Operation(summary = "Returns advertisement by advertisementId", description = "Returns advertisement by advertisementId")
    public AdvertisementResponse getAdvertisementById(@RequestParam Integer advertisementId) {
        AdvertisementResponse advertisement = advertisementsService.getAdvertisement(advertisementId);
        return advertisement;
    }

    @GetMapping("/my-advertisements-types")
    @Operation(summary = "Returns advertisement types", description = "Returns all advertisement types")
    public List<AdvertisementTypeDto> getAllAdvertisementTypes() {
        return advertisementTypesService.getAdvertisementTypes();
    }

    @DeleteMapping("/my-advertisements")
    @Operation(summary = "Deletes an advertisement", description = "Deletes advertisement by advertisementId")
    public void deleteAdvertisement(@RequestParam Integer advertisementId) {
        advertisementsService.deleteAdvertisement(advertisementId);
    }
}
