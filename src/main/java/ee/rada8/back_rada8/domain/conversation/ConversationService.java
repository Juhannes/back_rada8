package ee.rada8.back_rada8.domain.conversation;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation getConversation(Integer conversationId) {

        Optional<Conversation> conversation = conversationRepository.findById(conversationId);

        return conversation.get();

    }

}
