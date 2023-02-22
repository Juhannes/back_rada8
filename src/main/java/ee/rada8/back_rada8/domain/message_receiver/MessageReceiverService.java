package ee.rada8.back_rada8.domain.message_receiver;

import ee.rada8.back_rada8.domain.message.MessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class MessageReceiverService {



    @Resource
    private MessageReceiverRepository messageReceiverRepository;
    public List<List<MessageReceiver>> getReceivedConversations(Integer userId) {

        List<MessageReceiver> messageReceivers = messageReceiverRepository.findMessageReceiverEntries(userId);

        List<List<MessageReceiver>> messageGroups = new ArrayList<>();

        if (messageReceivers.size() > 0) {
            HashSet<Integer> conversationIdHashSet = new LinkedHashSet<>();

            for (MessageReceiver receiver : messageReceivers) {
                if (!conversationIdHashSet.contains(receiver.getConversation().getId())) {
                    conversationIdHashSet.add(receiver.getConversation().getId());
                }
            }
            List<Integer> uniqueConversationIds = conversationIdHashSet.stream().toList();
            int len = conversationIdHashSet.size();

            for (int i = 0; i < len; i++) {
                List<MessageReceiver> messageGroup = new ArrayList<>();
                for (MessageReceiver messageReceiver : messageReceivers) {
                    if (messageReceiver.getConversation().getId().equals(uniqueConversationIds.get(i))) {
                        messageGroup.add(messageReceiver);
                    }
                }
                messageGroups.add(messageGroup);
            }
        }

        return messageGroups;
    }
}
