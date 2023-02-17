package ee.rada8.back_rada8.forum.advertisements;

import ee.rada8.back_rada8.domain.advertisements.Advertisement;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Advertisement} entity
 */
@Data
public class AdvertisementDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    @Size(max = 255)
    @NotNull
    private final String header;
    @Size(max = 1000)
    @NotNull
    private final String body;
    private final Integer typeId;
    private final Integer cityId;
    private final String createdTimestamp;
    private final String editedTimestamp;
    @Size(max = 1)
    private final String status;
    private final String picture;
}