package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.forum.dtos.MessageDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper {

    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "datetime", target = "dateTime")
    @Mapping(source = "status", target = "status")
    MessageDto toDto(Message message);


    Message updateMessage(MessageDto messageDto, @MappingTarget Message message);
}