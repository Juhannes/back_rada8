package ee.rada8.back_rada8.domain.message_receiver;

import lombok.Data;

@Data
public class ReplyMessage {

    private Long id;

    private Integer senderId;

    private Integer receiverId;

    private Integer conversationId;

    private String replyBody;

}
