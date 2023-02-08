package ee.rada8.back_rada8.domain.message_receiver;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageReceiverService {
    @Resource
    MessageReceiverRepository messageReceiverRepository;
    public List<MessageReceiver> getReceivedConversations(Integer userId) {

        return messageReceiverRepository.findMessageReceiverEntries(userId);

    }

//    public void get
}
