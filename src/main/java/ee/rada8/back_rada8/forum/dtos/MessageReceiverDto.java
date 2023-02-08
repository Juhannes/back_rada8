package ee.rada8.back_rada8.forum.dtos;

import lombok.Data;

@Data
public class MessageReceiverDto {

    private Integer messageReceiverId;

    private Integer conversationId;

    private Integer messageId;

    private Integer senderId;

}
