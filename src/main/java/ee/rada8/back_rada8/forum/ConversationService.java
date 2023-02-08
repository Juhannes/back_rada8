package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.domain.message.Message;
import ee.rada8.back_rada8.domain.message.MessageMapper;
import ee.rada8.back_rada8.domain.message.MessageService;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiverService;
import ee.rada8.back_rada8.forum.dtos.MessageDto;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {
    @Resource
    private MessageService messageService;

    @Resource
    private MessageReceiverService messageReceiverService;

    private MessageMapper messageMapper;

    public List<MessageDto> getUserConversationsWithMessages(Integer userId) {

        // Sõnumi sisu leidmine ja lisamine messageDtos'sse: messageId, body, dateTime
        List<MessageReceiver> messageReceiverEntries = messageReceiverService.getReceivedConversations(userId);

        List<Message> messages = messageService.getAllMessages(messageReceiverEntries);

        List<MessageDto> messageDtos = messageMapper.toDtos(messages);

        // conversationId ja advertisementId leidmine ja lisamine
        for (MessageDto messageDto : messageDtos) {

        }


        return messageDtos;
    }
}


// private Integer messageId;
//
// TODO:  private Integer conversationId;
//
// TODO:  private String subject;
//
// TODO:  private User sender;
//
// private String body;
//
// private String dateTime;
//
// TODO:  private Integer advertisementId;