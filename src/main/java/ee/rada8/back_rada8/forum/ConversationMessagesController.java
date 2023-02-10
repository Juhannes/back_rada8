package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.domain.message.MessageService;
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
    @Operation(summary = "Tagastab kõik kasutaja sõnumid", description = "Otsib üles kõik sõnumid, kus kasutaja on receiver rollis")
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

}
