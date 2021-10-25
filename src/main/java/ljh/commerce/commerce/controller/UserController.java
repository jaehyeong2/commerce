package ljh.commerce.commerce.controller;

import ljh.commerce.commerce.domain.user.User;
import ljh.commerce.commerce.dto.SignUpDto;
import ljh.commerce.commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signUpForm() {
        return "signup";
    }

    @GetMapping("/signin")
    public String signInForm() {
        return "signin";
    }

    @PostMapping("/signup")
    public String signUp(SignUpDto signUpDto){
        User user = signUpDto.toEntity();
        User userEntity = userService.join(user);
        return "signin";
    }
}
