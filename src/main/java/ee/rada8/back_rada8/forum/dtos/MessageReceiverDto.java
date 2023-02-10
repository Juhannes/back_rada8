package ee.rada8.back_rada8.forum.dtos;

import ee.rada8.back_rada8.domain.message.Message;
import lombok.Data;

@Data
public class MessageReceiverDto {

    private Integer messageReceiverId;

    private Integer conversationId;

    private Message message;

    private Integer senderId;

}
