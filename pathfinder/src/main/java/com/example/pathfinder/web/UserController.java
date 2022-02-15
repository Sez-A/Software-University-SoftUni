package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.UserLoginBindingModel;
import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.service.UserLoginServiceModel;
import com.example.pathfinder.model.service.UserRegisterServiceModel;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller()
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword()) ||
                bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);
            return "redirect:register";
        }

        this.userService.register(this.modelMapper.map
                (userRegisterBindingModel, UserRegisterServiceModel.class));

        return "redirect:login";

    }

    @GetMapping("/login")
    public String login(Model model) {
         if(!model.containsAttribute("invalidUsername")) {
             model.addAttribute("invalidUsername", false);
         }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel loginBindingModel, Model model) {
        boolean successfulLogin = this.userService.loginUser(this.modelMapper.map(loginBindingModel, UserLoginServiceModel.class));

        if (successfulLogin) {
            return "redirect:/";
        }

        model.addAttribute("invalidUsername", true);
        return "login";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id) {
        return "profile";
    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }
}
