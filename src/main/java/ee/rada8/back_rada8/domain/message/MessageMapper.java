package ee.rada8.back_rada8.domain.message;

import ee.rada8.back_rada8.forum.dtos.MessageDto;
import ee.rada8.back_rada8.util.PictureUtil;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface MessageMapper {

    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "datetime", target = "dateTime")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(message.getPicture()))", target = "picture")
    MessageDto toDto(Message message);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {

        if (picture == null || "".equals(picture)) {
            return null;
        }
        byte[] bytes = picture.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    List<MessageDto> toDtos(List<Message> messages);

    @Mapping(source = "body", target = "body")
    @Mapping(source = "dateTime", target = "datetime")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "picture", target = "picture", qualifiedByName = "stringToByteArray")
    Message toEntity(MessageDto messageDto);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Message updateMessage(MessageDto messageDto, @MappingTarget Message message);

}