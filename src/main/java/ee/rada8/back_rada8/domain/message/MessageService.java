package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.domain.conversation.Conversation;
import ee.rada8.back_rada8.domain.conversation.ConversationRepository;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import ee.rada8.back_rada8.domain.message_receiver.MessageReceiverRepository;
import ee.rada8.back_rada8.domain.message_receiver.ReplyMessage;
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
    private MessageMapper messageMapper;

    @Resource
    private MessageReceiverRepository messageReceiverRepository;

    @Resource
    private ConversationRepository conversationRepository;

    @Resource
    private UserRepository userRepository;

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

    private void updateAndSaveMessage(Integer messageId, MessageDto messageDto) {
        Message message = getUpdatedMessage(messageId, messageDto);
        saveMessage(message);
    }

    private Message getUpdatedMessage(Integer messageId, MessageDto messageDto) {

        Message message = getMessage(messageId);
        messageMapper.updateMessage(messageDto, message);
        message.setStatus(ACTIVE);
        return message;
    }

    public void replyToMessage(ReplyMessage replyMessage) {
        MessageReceiver messageReceiver = createReplyMessageReceiver(replyMessage);
        messageReceiverRepository.save(messageReceiver);
    }

    private MessageReceiver createReplyMessageReceiver(ReplyMessage replyMessage) {
        Integer messageId = createAndSaveMessage(replyMessage.getReplyBody());

        MessageReceiver messageReceiver = new MessageReceiver();
        Optional<Message> message = messageRepository.findById(messageId);
        messageReceiver.setMessage(message.get());

        Optional<Conversation> conversation = conversationRepository.findById(replyMessage.getConversationId());
        messageReceiver.setConversation(conversation.get());

        Optional<User> sender = userRepository.findById(replyMessage.getSenderId());
        messageReceiver.setSender(sender.get());

        Optional<User> receiver = userRepository.findById(replyMessage.getReceiverId());
        messageReceiver.setReceiver(receiver.get());
        return messageReceiver;
    }


    private Integer createAndSaveMessage(String replyBody) {
        MessageDto messageDto = new MessageDto();
        System.out.println(replyBody);
        messageDto.setBody(replyBody);
        messageDto.setStatus(ACTIVE);
        Message message = messageMapper.toEntity(messageDto);
        message.setDatetime(Instant.now());
        messageRepository.save(message);
        System.out.println(message);
        System.out.println(message.getBody());
        return message.getId();
    }
}