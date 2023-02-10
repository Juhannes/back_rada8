package ee.rada8.back_rada8.forum.new_user;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
}
