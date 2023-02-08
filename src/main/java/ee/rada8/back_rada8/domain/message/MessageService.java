package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Message getMessage(Integer messageId) {

        Optional<Message> message = messageRepository.findById(messageId);

        return message.get();
    }
}