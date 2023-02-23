package ee.rada8.back_rada8.forum.new_user;

import ee.rada8.back_rada8.domain.user.User;
import ee.rada8.back_rada8.domain.user.UserMapper;
import ee.rada8.back_rada8.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class NewUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    public void addUser(NewUserDto newUserDto) {
        User user = userMapper.toEntity(newUserDto);
        userService.saveNewUser(user);

    }
}
