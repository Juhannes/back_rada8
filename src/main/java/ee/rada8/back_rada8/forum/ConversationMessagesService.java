package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.domain.Advertisement.Advertisement;
import ee.rada8.back_rada8.domain.conversation.Conversation;
import ee.rada8.back_rada8.domain.conversation.ConversationService;
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
public class ConversationMessagesService {
    @Resource
    private MessageService messageService;

    @Resource
    private MessageReceiverService messageReceiverService;

    @Resource
    private ConversationService conversationService;

    private MessageMapper messageMapper;

    public List<MessageDto> getUserConversationsWithMessages(Integer userId) {

        // Sõnumi sisu leidmine ja lisamine messageDtos'sse: messageId, body, dateTime
        List<MessageReceiver> messageReceiverEntries = messageReceiverService.getReceivedConversations(userId);

        List<Message> messages = messageService.getAllMessages(messageReceiverEntries);

        List<MessageDto> messageDtos = messageMapper.toDtos(messages);

        // conversationId ja advertisementId leidmine ja lisamine
        for (MessageDto messageDto : messageDtos) {
            MessageReceiver messageReceiver = messageReceiverService.getMessageReceiver(messageDto.getMessageId());
            Conversation conversation = conversationService.getConversation(messageReceiver.getId());
            messageDto.setConversationId(conversation.getId());
            messageDto.setAdvertisementId(conversation.getAdvertisement().getId());
            messageDto.setSubject(conversation.getSubject());
            messageDto.setSender(messageReceiver.getSender());

        }


        return messageDtos;
    }
}

// TESTI KAS ON VALMIS!!!

// private Integer messageId;
//
// private Integer conversationId;
//
// private String subject;
//
//  private User sender;
//
// private String body;
//
// private String dateTime;
//
// private Integer advertisementId;