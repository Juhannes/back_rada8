package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.domain.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.rada8.back_rada8.validation.Validator.getValidUser;


@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findUser(username, password);

        return getValidUser(optionalUser);
    }


    public void saveNewUser(User user) {
        userRepository.save(user);
    }
}
