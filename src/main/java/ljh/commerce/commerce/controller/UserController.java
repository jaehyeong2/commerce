package ljh.commerce.commerce.controller;

import ljh.commerce.commerce.domain.user.User;
import ljh.commerce.commerce.dto.SignUpDto;
import ljh.commerce.commerce.global.GlobalData;
import ljh.commerce.commerce.handler.ex.CustomValidationException;
import ljh.commerce.commerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
        GlobalData.cart.clear();
        return "signin";
    }

    @PostMapping("/signup")
    public String signUp(@Valid SignUpDto signUpDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error:bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패",errorMap);
        }else {
            User user = signUpDto.toEntity();
            User userEntity = userService.join(user);
            return "signin";
        }
    }
}
