package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.forum.dtos.UserDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.rada8.back_rada8.validation.Validator.getValidUser;


@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;


    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findUser(username, password);

        return getValidUser(optionalUser);
    }


    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    public User findUser(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public UserDto findUserBy(Integer userId) {
        return userMapper.toDto(userRepository.findById(userId).get());
    }

}
