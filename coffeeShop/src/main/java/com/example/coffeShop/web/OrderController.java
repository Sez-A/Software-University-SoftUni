package com.example.coffeShop.web;

import com.example.coffeShop.model.binding.AddOrderBindingModel;
import com.example.coffeShop.model.service.OrderServiceModel;
import com.example.coffeShop.service.OrderService;
import com.example.coffeShop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    public OrderController(OrderService orderService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public AddOrderBindingModel addOrderBindingModel() {
        return new AddOrderBindingModel();
    }

    @GetMapping("/add")
    public String addOrder() {
        if(currentUser.getId() == null) {
            return "redirect:/";
        }
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrderPost(@Valid AddOrderBindingModel addOrderBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOrderBindingModel", addOrderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOrderBindingModel", bindingResult);
            return "redirect:add";
        }

        this.orderService.addOrder(this.modelMapper.map(addOrderBindingModel, OrderServiceModel.class));

        return "redirect:/home";
    }
}
