package com.example.cafeshop.web;

import com.example.cafeshop.model.binding.AddOrderBindingModel;
import com.example.cafeshop.model.service.OrderServiceModel;
import com.example.cafeshop.service.OrderService;
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

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AddOrderBindingModel addOrderBindingModel() {
        return new AddOrderBindingModel();
    }

    @GetMapping("/add")
    public String addOrder() {
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
