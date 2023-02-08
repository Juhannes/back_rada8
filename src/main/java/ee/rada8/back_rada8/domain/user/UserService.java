package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.domain.User;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        //leiab repositorist useri ja paneb andmed user objekti sisse
        User user = userRepository.findUser(username, password);
        // tagastab user objekti, login service klassi kust see välja kutsuti
        return user;
    }
}
