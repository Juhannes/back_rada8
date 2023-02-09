package ee.rada8.back_rada8.forum.login;

import lombok.Data;

@Data
public class LoginResponse {
    private Integer userId;
    private String userName;
    private String email;
}
