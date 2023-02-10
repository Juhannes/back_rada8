package ee.rada8.back_rada8.forum.login;

import ee.rada8.back_rada8.domain.user.User;
import ee.rada8.back_rada8.domain.user.UserMapper;
import ee.rada8.back_rada8.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

@Resource
private UserService userService;
@Resource
private UserMapper userMapper;


    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);

        return userMapper.toLoginDto(user);
    }
}
