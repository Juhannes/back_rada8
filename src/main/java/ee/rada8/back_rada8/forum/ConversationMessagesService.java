package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.domain.MessageStatus;
import ee.rada8.back_rada8.domain.conversation.Conversation;
import ee.rada8.back_rada8.domain.conversation.ConversationMapper;
import ee.rada8.back_rada8.domain.message.Message;
import ee.rada8.back_rada8.domain.message.MessageMapper;
import ee.rada8.back_rada8.domain.message.MessageService;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiverService;
import ee.rada8.back_rada8.domain.user.User;
import ee.rada8.back_rada8.domain.user.UserMapper;
import ee.rada8.back_rada8.forum.dtos.ConversationDto;
import ee.rada8.back_rada8.forum.dtos.MessageDto;
import ee.rada8.back_rada8.forum.dtos.ReceivedMessageDto;
import ee.rada8.back_rada8.forum.dtos.UserDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static ee.rada8.back_rada8.domain.MessageStatus.TRASH;


@Service
public class ConversationMessagesService {

    @Resource
    private MessageReceiverService messageReceiverService;

    @Resource
    private MessageService messageService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private ConversationMapper conversationMapper;

    public void deleteMessage(Integer messageId) {
        Message message = messageService.getMessage(messageId);
        message.setStatus(TRASH);
        messageService.saveMessage(message);
    }

    public List<ReceivedMessageDto> getUserConversationsWithMessages(Integer userId) throws ParseException {

        // Sõnumi sisu leidmine ja lisamine messageDtos'sse: messageId, body, dateTime
        List<MessageReceiver> receivedConversationData = messageReceiverService.getReceivedConversations(userId);
        List<ReceivedMessageDto> receivedMessageDtos = new ArrayList<>();

        for (MessageReceiver receivedConversation : receivedConversationData) {
            ReceivedMessageDto receivedMessageDto = new ReceivedMessageDto();
            addMessageDtoToReceivedMessageDto(receivedConversation, receivedMessageDto);
            addConversationDtoToReceivedMessageDto(receivedConversation, receivedMessageDto);
            addUserDtoToReceivedMessageDto(receivedConversation, receivedMessageDto);
            receivedMessageDtos.add(receivedMessageDto);
        }


        return receivedMessageDtos;
    }

    private void addUserDtoToReceivedMessageDto(MessageReceiver receivedConversation, ReceivedMessageDto receivedMessageDto) {
        User sender = receivedConversation.getSender();
        UserDto userDto = userMapper.toDto(sender);
        receivedMessageDto.setSender(userDto);
    }

    private void addConversationDtoToReceivedMessageDto(MessageReceiver receivedConversation, ReceivedMessageDto receivedMessageDto) {
        Conversation conversation = receivedConversation.getConversation();
        ConversationDto conversationDto = conversationMapper.toDto(conversation);
        receivedMessageDto.setConversationId(conversationDto.getConversationId());
        receivedMessageDto.setSubject(conversationDto.getSubject());
        receivedMessageDto.setAdvertisementId(conversationDto.getAdvertisementId());
    }

    private void addMessageDtoToReceivedMessageDto(MessageReceiver messageReceiverEntry, ReceivedMessageDto receivedMessageDto) throws ParseException {
        Message message = messageReceiverEntry.getMessage();

        MessageDto messageDto = messageMapper.toDto(message);
        receivedMessageDto.setMessageId(messageDto.getMessageId());
        receivedMessageDto.setBody(messageDto.getBody());

        String outputFormat = "dd/MM/yyyy HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(outputFormat).withZone(ZoneId.systemDefault());
        String formattedTimestamp = formatter.format(message.getDatetime());

        receivedMessageDto.setDateTime(formattedTimestamp);
        receivedMessageDto.setStatus(messageDto.getStatus());

    }
}