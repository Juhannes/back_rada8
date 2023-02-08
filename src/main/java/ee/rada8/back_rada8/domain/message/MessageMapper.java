package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.domain.message_receiver.MessageReceiver;
import ee.rada8.back_rada8.forum.dtos.MessageDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper {

    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "datetime", target = "dateTime")
//    @Mapping(source = "picture", target = "picture")
    MessageDto toDto(Message message);

    List<MessageDto> toDtos(List<Message> messages);

}

// TODO: Vaja teha picture convert from byte to String ja ära mappida