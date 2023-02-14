package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.domain.message.MessageService;
import ee.rada8.back_rada8.domain.message_receiver.ReplyMessage;
import ee.rada8.back_rada8.forum.dtos.MessageDto;
import ee.rada8.back_rada8.forum.dtos.ReceivedMessageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ConversationMessagesController {

    @Resource
    private ConversationMessagesService conversationMessagesService;

    @Resource
    private MessageService messageService;

    @GetMapping("/message")
    @Operation(summary = "Returns all user's messages", description = "Finds all messages where user is receiver")
    public List<ReceivedMessageDto> getUserMessages(@RequestParam Integer userId) throws ParseException {
        List<ReceivedMessageDto> conversations = conversationMessagesService.getUserConversationsWithMessages(userId);
        return conversations;
    }

    @DeleteMapping("/message")
    @Operation(summary = "Sends message to trash", description = "Changes message status in db to 'T'")
    public void deleteMessage(@RequestParam Integer messageId) {
        conversationMessagesService.deleteMessage(messageId);
    }

    @PutMapping("/message")
    @Operation(summary = "Restores message from trash", description = "Changes message status in db to 'A'")
    public void restoreMessage(@RequestParam Integer messageId, @RequestBody MessageDto messageDto) {
        messageService.restoreMessage(messageId, messageDto);
    }

    @PostMapping("/message/reply")
    @Operation(summary = "Replying to an incoming message", description = "Inserts a new message to conversation_receiver")
    public void replyToMessage(@RequestBody ReplyMessage replyMessage) {
        messageService.replyToMessage(replyMessage);
    }

}
