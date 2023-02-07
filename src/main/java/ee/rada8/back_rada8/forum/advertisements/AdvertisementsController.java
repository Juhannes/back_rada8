package ee.rada8.back_rada8.forum.advertisements;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdvertisementsController {

    @Resource
    private AdvertisementsService advertisementsService;

    @PostMapping("/myadvertisements")
    @Operation(summary = "Adds new advertisement", description = "Adds new advertisement to table 'advertisement'")
    public void addAdvertisement (@RequestBody AdvertisementDto advertisementDto) {
        advertisementsService.addAdvertisement(advertisementDto);
    }

    @PutMapping("/myadvertisements")
    @Operation(summary = "Modifies existing advertisement", description = "Modifies an advertisement in table 'advertisement', finds by advertisementId")
    public void editAdvertisement(@RequestParam Integer advertisementId, @RequestBody AdvertisementDto advertisementDto) {
        advertisementsService.editAdvertisement(advertisementId, advertisementDto);
    }

}
