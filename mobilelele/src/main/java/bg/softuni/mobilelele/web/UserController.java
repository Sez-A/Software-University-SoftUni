package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String registerUser() {
        return "auth-register";
    }


    @PostMapping("/register")
    public String register(UserRegisterBindingModel registerBindingModel) {

        if (this.userService.userNameFree(registerBindingModel.getUsername())) {
            this.userService.register(registerBindingModel);
            return "redirect:/";
        } else {
            // TODO: 10.2.2022 г. Show message with flash attribute maybe here redirect should be "redirect/users/login"
            return "redirect:/auth-register";
        }

    }

    @GetMapping("/login")
    public String loginUser() {
        return "auth-login";
    }

    @PostMapping("/login-error")
    public String failedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                    String userName,
            RedirectAttributes redirectAttributes
    ) {

        redirectAttributes.addFlashAttribute("bad_credentials", true);
        redirectAttributes.addFlashAttribute("username", userName);

        return "redirect:/users/login";

    }
}
