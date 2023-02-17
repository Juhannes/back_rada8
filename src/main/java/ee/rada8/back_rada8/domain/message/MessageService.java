package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.domain.advertisements.Advertisement;
import ee.rada8.back_rada8.domain.conversation.Conversation;
import ee.rada8.back_rada8.domain.conversation.ConversationRepository;
import ee.rada8.back_rada8.domain.message_receiver.IncomingMessage;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiverRepository;
import ee.rada8.back_rada8.domain.user.User;
import ee.rada8.back_rada8.domain.user.UserRepository;
import ee.rada8.back_rada8.forum.dtos.MessageDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

import static ee.rada8.back_rada8.domain.MessageStatus.ACTIVE;

@Service
public class MessageService {

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private MessageReceiverRepository messageReceiverRepository;

    @Resource
    private ConversationRepository conversationRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository,
                          MessageReceiverRepository messageReceiverRepository,
                          ConversationRepository conversationRepository,
                          UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.messageReceiverRepository = messageReceiverRepository;
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
    }


    public Message getMessage(Integer messageId) {

        Optional<Message> message = messageRepository.findById(messageId);

        return message.get();
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public void restoreMessage(Integer messageId, MessageDto messageDto) {
        updateAndSaveMessage(messageId, messageDto);
    }

    public void updateAndSaveMessage(Integer messageId, MessageDto messageDto) {
        Message message = getUpdatedMessage(messageId, messageDto);
        saveMessage(message);
    }

    public Message getUpdatedMessage(Integer messageId, MessageDto messageDto) {

        Message message = getMessage(messageId);
        messageMapper.updateMessage(messageDto, message);
        message.setStatus(ACTIVE);
        return message;
    }

    public void replyToMessage(IncomingMessage replyMessage) {
        MessageReceiver messageReceiver = createMessageAndMessageReceiver(replyMessage);
        messageReceiverRepository.save(messageReceiver);
    }

    public MessageReceiver createMessageAndMessageReceiver(IncomingMessage incomingMessage) {
        Integer messageId = createAndSaveMessage(incomingMessage.getMessageBody());

        MessageReceiver messageReceiver = new MessageReceiver();
        Optional<Message> message = messageRepository.findById(messageId);
        messageReceiver.setMessage(message.get());

        if (incomingMessage.getConversationId() != 0) {
            Optional<Conversation> conversation = conversationRepository.findById(incomingMessage.getConversationId());
            messageReceiver.setConversation(conversation.get());
        }

        Optional<User> sender = userRepository.findById(incomingMessage.getSenderId());
        messageReceiver.setSender(sender.get());

        Optional<User> receiver = userRepository.findById(incomingMessage.getReceiverId());
        messageReceiver.setReceiver(receiver.get());
        return messageReceiver;
    }


    public Integer createAndSaveMessage(String messageBody) {
        MessageDto messageDto = new MessageDto();
        messageDto.setBody(messageBody);
        messageDto.setStatus(ACTIVE);
        Message message = messageMapper.toEntity(messageDto);
        message.setDatetime(Instant.now());
        messageRepository.save(message);
        return message.getId();
    }

    public Integer createNewConversation(Advertisement advertisement) {
        Conversation newConversation = new Conversation();
        newConversation.setSubject(advertisement.getHeader());
        newConversation.setAdvertisement(advertisement);
        newConversation.setDatetime(Instant.now());
        conversationRepository.save(newConversation);
        return newConversation.getId();
    }
}