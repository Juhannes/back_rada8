package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.forum.dtos.UserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "userName")
    @Mapping(source = "email", target = "email")
    UserDto toDto(User user);


}