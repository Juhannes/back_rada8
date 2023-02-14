package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.forum.dtos.MessageDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper {

    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "datetime", target = "dateTime")
    MessageDto toDto(Message message);

    List<MessageDto> toDtos(List<Message> messages);

    Message updateMessage(MessageDto messageDto, @MappingTarget Message message);

    @Mapping(source = "body", target = "body")
    @Mapping(source = "dateTime", target = "datetime")
    @Mapping(source = "status", target = "status")
    Message toEntity(MessageDto messageDto);
}