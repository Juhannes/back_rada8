package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.forum.dtos.UserDto;
import ee.rada8.back_rada8.forum.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {


    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "userName")
    @Mapping(source = "email", target = "email")
    UserDto toDto(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    @Mapping(constant = "2", target = "role.id")
    User toEntity(ee.rada8.back_rada8.forum.new_user.UserDto userDto);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "email", target = "email")
    LoginResponse toLoginDto(User user);


}