package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


    public List<Message> getAllMessages(List<MessageReceiver> messageReceiverEntries) {

        List<Message> messages = null;

        for (MessageReceiver messageReceiverEntry : messageReceiverEntries) {

            messages.add(messageReceiverEntry.getMessage());


        }
        return messages;

    }
}