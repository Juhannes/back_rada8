package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.forum.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "userName")
    LoginResponse toDto(User user);



}