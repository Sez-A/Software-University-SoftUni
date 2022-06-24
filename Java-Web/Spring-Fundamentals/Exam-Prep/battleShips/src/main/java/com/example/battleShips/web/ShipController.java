package com.example.battleShips.web;

import com.example.battleShips.model.binding.AddShipBindingModel;
import com.example.battleShips.model.service.ShipServiceModel;
import com.example.battleShips.service.ShipService;
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
@RequestMapping("/ships")
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AddShipBindingModel addShipBindingModel() {
        return new AddShipBindingModel();
    }


    @GetMapping("/add")
    public String addShip() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShipPost(@Valid AddShipBindingModel addShipBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addShipBindingModel", addShipBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addShipBindingModel",
                    bindingResult);
            return "redirect:add";
        }

        shipService.addShip(modelMapper.map(addShipBindingModel, ShipServiceModel.class));
        return "redirect:/home";
    }

}
