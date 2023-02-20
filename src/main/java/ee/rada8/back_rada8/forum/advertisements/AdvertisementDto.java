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
    private Integer id;
    private Integer userId;
    @Size(max = 255)
    @NotNull
    private String header;
    @Size(max = 1000)
    @NotNull
    private String body;
    private Integer typeId;
    private Integer cityId;
    private String cityName;
    private String createdTimestamp;
    private String editedTimestamp;
    @Size(max = 1)
    private String status;
    private String picture;
}