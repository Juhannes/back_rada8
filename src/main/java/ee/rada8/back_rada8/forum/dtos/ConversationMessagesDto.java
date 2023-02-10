package ee.rada8.back_rada8.forum.dtos;

import ee.rada8.back_rada8.domain.user.User;
import ee.rada8.back_rada8.domain.message.Message;
import lombok.Data;

import java.util.List;

@Data
public class ConversationMessagesDto {

    private Integer conversationId;

    private User sender;

    private List<Message> message;

    private Integer advertisementId;

}
