package ee.rada8.back_rada8.domain.message_receiver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageReceiverRepository extends JpaRepository<MessageReceiver, Integer> {
    @Query("select m from MessageReceiver m where m.receiver.id = ?1 order by m.conversation.id")
    List<MessageReceiver> findMessageReceiverEntries(Integer receiverId);

    @Query("select m from MessageReceiver m where m.message.id = ?1")
    MessageReceiver findByMessage(Integer messageId);



}