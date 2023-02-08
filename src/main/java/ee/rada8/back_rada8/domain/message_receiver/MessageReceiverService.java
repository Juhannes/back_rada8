package ee.rada8.back_rada8.domain.message_receiver;

import ee.rada8.back_rada8.domain.message.Message;
import ee.rada8.back_rada8.domain.message.MessageMapper;
import ee.rada8.back_rada8.domain.message.MessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageReceiverService {
    @Resource
    private MessageMapper messageMapper;

    @Resource
    private MessageService messageService;

    @Resource
    private MessageReceiverRepository messageReceiverRepository;
    public List<MessageReceiver> getReceivedConversations(Integer userId) {

        List<MessageReceiver> messageReceivers = messageReceiverRepository.findMessageReceiverEntries(userId);
        for (MessageReceiver messageReceiver : messageReceivers) {

            Integer messageId = messageReceiver.getMessage().getId();
            Message message = messageService.getMessage(messageId);
            messageReceiver.setMessage(message);
        }

        return messageReceivers;
    }

    public MessageReceiver getMessageReceiver(Integer messageId) {

        return messageReceiverRepository.findByMessage(messageId);

    }
}
