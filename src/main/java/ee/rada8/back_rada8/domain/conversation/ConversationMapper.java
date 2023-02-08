package ee.rada8.back_rada8.domain.conversation;

import ee.rada8.back_rada8.forum.dtos.ConversationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConversationMapper {
    ConversationDto toDto(Conversation conversation);

}