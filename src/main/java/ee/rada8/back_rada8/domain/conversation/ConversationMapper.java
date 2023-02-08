package ee.rada8.back_rada8.domain.conversation;

import ee.rada8.back_rada8.forum.dtos.ConversationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConversationMapper {

    @Mapping(source = "id", target = "conversationId")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "datetime", target = "dateTime")
    @Mapping(source = "advertisement.id", target = "advertisementId")
    ConversationDto toDto(Conversation conversation);

}