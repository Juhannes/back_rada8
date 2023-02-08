package ee.rada8.back_rada8.forum.login;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
//@Resource annab juurdepääsu selle all olevale klassile
    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        // kutsub välja login meetodi andes kaasa username ja passwordi
        LoginResponse loginResponse = loginService.login(username, password);

        return loginResponse;
    }

}
