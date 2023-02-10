package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.advertisements.advertisement_type.AdvertisementType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link AdvertisementType} entity
 */
@Data
public class AdvertisementTypeDto implements Serializable {
    private final Integer id;
    @Size(max = 20)
    @NotNull
    private final String name;
}