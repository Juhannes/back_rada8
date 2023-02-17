package ee.rada8.back_rada8.domain.conversation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    @Query("select c from Conversation c where c.advertisement.id = ?1 order by c.id")
    List<Conversation> findConversationsBy(Integer advertisementId);



}