package com.example.cafeshop.web;

import com.example.cafeshop.service.OrderService;
import com.example.cafeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final OrderService orderService;
    private final UserService userService;

    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("orders", this.orderService.getAllOrdersOrderedByPriceDesc());
        model.addAttribute("neededTime", this.orderService.totalNeededTime());
        model.addAttribute("employees", this.userService.findAll());
        return "home";
    }

    @GetMapping("/orders/ready/{id}")
    public String ready(@PathVariable Long id) {
        this.orderService.deleteById(id);
        return "redirect:/home";
    }
}
