package ee.rada8.back_rada8.forum.dtos;

import lombok.Data;

@Data
public class MessageDto {

    private Integer messageId;

    private Integer conversationId;

    private String subject;

    private UserDto sender;

    private String body;

//    private String picture;
    private String dateTime;

    private Integer advertisementId;

}

// TODO: Vaja lisada picture (ja võibolla status)