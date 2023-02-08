package ee.rada8.back_rada8.forum.dtos;

import lombok.Data;

@Data
public class ConversationDto {

    private Integer conversationId;

    private String dateTime;

    private String subject;

    private Integer advertisementId;

}
