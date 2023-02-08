package ee.rada8.back_rada8.forum.dtos;

import ee.rada8.back_rada8.domain.User;
import lombok.Data;

@Data
public class MessageDto {

    private Integer messageId;

    private Integer conversationId;

    private String subject;

    private User sender;

    private String body;

    private String dateTime;

    private Integer advertisementId;

}
