package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.forum.dtos.ReceivedMessageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConversationMessagesController {

    @Resource
    private ConversationMessagesService conversationMessagesService;

    @GetMapping("/message")
    @Operation(summary = "Tagastab kõik kasutaja sõnumid", description = "Otsib üles kõik sõnumid, kus kasutaja on receiver rollis")
    public List<ReceivedMessageDto> getUserMessages(@RequestParam Integer userId) {
        List<ReceivedMessageDto> conversations = conversationMessagesService.getUserConversationsWithMessages(userId);

        return conversations;

    }
}
