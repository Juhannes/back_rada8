package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.domain.User;
import ee.rada8.back_rada8.forum.login.LoginResponse;
import ee.rada8.back_rada8.forum.new_user.UserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "email",target = "email")
    @Mapping(constant = "2", target = "role.id")
    User toEntity(UserDto userDto);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "userName")
    LoginResponse toDto(User user);



}