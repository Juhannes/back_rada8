package ee.rada8.back_rada8.domain.message_receiver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageReceiverRepository extends JpaRepository<MessageReceiver, Integer> {

    @Query("select m from MessageReceiver m where m.sender.id = ?1 or m.receiver.id = ?1 order by m.message.datetime DESC, m.conversation.id DESC")
    List<MessageReceiver> findMessageReceiverEntries(Integer userId);

    @Query("select m from MessageReceiver m where m.conversation.id = ?1 and m.sender.id = ?2")
    List<MessageReceiver> findConversationBy(Integer conversationId, Integer senderId);



}