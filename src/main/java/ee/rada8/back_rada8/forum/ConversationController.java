package ee.rada8.back_rada8.forum;

import ee.rada8.back_rada8.forum.dtos.ConversationMessagesDto;
import ee.rada8.back_rada8.forum.dtos.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConversationController {

    @Resource
    private ConversationService conversationService;

    @GetMapping("/message")
    @Operation(summary = "Tagastab kõik kasutaja sõnumid", description = "Otsib üles kõik sõnumid, kus kasutaja on receiver rollis")
    public List<MessageDto> getUserMessages(@RequestParam Integer userId) {
        List<MessageDto> conversations = conversationService.getUserConversationsWithMessages(userId);

        return conversations;

    }
}
