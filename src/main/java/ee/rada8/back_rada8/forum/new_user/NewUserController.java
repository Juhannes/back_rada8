package ee.rada8.back_rada8.forum.new_user;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewUserController {
    @Resource
    private NewUserService newUserService;
    @PostMapping("/register")
    @Operation(summary = "Add new user to database", description = "Default usertype will be 'user'")
    public void addUser(@RequestBody UserDto userDto) {
        newUserService.addUser(userDto);

    }
}
