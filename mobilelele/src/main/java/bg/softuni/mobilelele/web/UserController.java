package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/register")
    public String registerUser() {
        return "auth-register";
    }


    @PostMapping("/users/register")
    public String register(UserRegisterBindingModel registerBindingModel) {

        if (this.userService.userNameFree(registerBindingModel.getUsername())) {
            this.userService.register(registerBindingModel);
            return "redirect:/";
        } else {
            // TODO: 10.2.2022 г. Show message with flash attribute
            return "redirect:/users/register";
        }

    }

    @GetMapping("/users/login")
    public String loginUser() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel loginBindingModel,
                        BindingResult bindingResult,
                        Model model) {

        if (this.userService.authenticate(loginBindingModel)) {
            return "redirect:/";
        }


        model.addAttribute("error", true);
        return "auth-login";
    }

    @GetMapping("/users/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }
}
