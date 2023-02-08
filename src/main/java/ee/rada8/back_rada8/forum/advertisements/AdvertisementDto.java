package ee.rada8.back_rada8.forum.advertisements;

import lombok.Data;

@Data
public class AdvertisementDto {
    private Integer userId;
    private String header;
    private String body;
    private Integer typeId;
    private Integer cityId;
    private String createdTimestamp;
    private String modifiedTimestamp;
    private String status;
    private String picture;
}
