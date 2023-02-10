package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.domain.MessageStatus;
import ee.rada8.back_rada8.forum.dtos.MessageDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.rada8.back_rada8.domain.MessageStatus.ACTIVE;

@Service
public class MessageService {
    @Resource
    private MessageRepository messageRepository;

    @Resource
    private MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
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
}