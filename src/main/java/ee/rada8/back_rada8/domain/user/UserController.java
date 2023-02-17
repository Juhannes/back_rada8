package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.forum.dtos.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    @Operation(summary = "Finds user by ID")
    private UserDto findUser(@RequestParam Integer userId) {
        return userService.findUserBy(userId);
    }
}
