package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.AddRouteBindingModel;
import com.example.pathfinder.model.service.AddRouteServiceModel;
import com.example.pathfinder.model.view.RouteDetailsView;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping("/routes")
public class RouteController {
    private static final String PEDESTRIAN_CATEGORY_NAME = "PEDESTRIAN";
    private static final String BICYCLE_CATEGORY_NAME = "BICYCLE";
    private static final String MOTORCYCLE_CATEGORY_NAME = "MOTORCYCLE";
    private static final String CAR_CATEGORY_NAME = "CAR";

    private final RouteService routeService;
    private final CurrentUser currentUser;
private final ModelMapper modelMapper;
    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public String allRoutes(Model model) {
        model.addAttribute("routes", this.routeService.getAllRoutes());
        return "routes";
    }

    @ModelAttribute
    public AddRouteBindingModel addRouteBindingModel() {
        return new AddRouteBindingModel();
    }

    @GetMapping("/add")
    public String addRoute() {
        if (currentUser.getId() == null) {
            return "redirect:/";
        }
        return "add-route";
    }

    @PostMapping("/add")
public String addRoutePost(@Valid AddRouteBindingModel addRouteBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRouteBindingModel",addRouteBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRouteBindingModel"
                    ,bindingResult);

            return "redirect:add";
        }

        this.routeService.addRoute(this.modelMapper.map(addRouteBindingModel, AddRouteServiceModel.class));

        return "redirect:/routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        RouteDetailsView routeDetailsView = this.routeService.findRouteById(id);
        model.addAttribute("routeDetails", routeDetailsView);
        return "route-details";
    }

    @GetMapping("/pedestrian")
    public String pedestrian(Model model) {

        model.addAttribute("routeByCategory", this.routeService.findAllRoutesByCategory(PEDESTRIAN_CATEGORY_NAME));
        return "pedestrian";
    }

    @GetMapping("/motorcycle")
    public String motorcycle(Model model) {
        model.addAttribute("routeByCategory", this.routeService.findAllRoutesByCategory(MOTORCYCLE_CATEGORY_NAME));
        return "motorcycle";
    }

    @GetMapping("/bicycle")
    public String bicycle(Model model) {
        model.addAttribute("routeByCategory", this.routeService.findAllRoutesByCategory(BICYCLE_CATEGORY_NAME));
        return "bicycle";
    }

    @GetMapping("/car")
    public String car(Model model) {
        model.addAttribute("routeByCategory", this.routeService.findAllRoutesByCategory(CAR_CATEGORY_NAME));
        return "car";
    }

}
