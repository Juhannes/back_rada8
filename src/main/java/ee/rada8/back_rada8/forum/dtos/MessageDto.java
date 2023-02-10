package ee.rada8.back_rada8.forum.dtos;

import lombok.Data;

@Data
public class MessageDto {

    private Integer messageId;

    private String body;

    private String dateTime;

    private String status;

}
