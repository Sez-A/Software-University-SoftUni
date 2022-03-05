package com.example.pathfinder.web;

import com.example.pathfinder.model.view.RouteDetailsView;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
    }

    @GetMapping("")
    public String allRoutes(Model model) {
        model.addAttribute("routes", this.routeService.getAllRoutes());
        return "routes";
    }

    @GetMapping("/add")
    public String addRoute() {
        if (currentUser.getId() == null) {
            return "redirect:/";
        }
        return "add-route";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        RouteDetailsView routeDetailsView = this.routeService.findRouteById(id);
        model.addAttribute("routeDetails", routeDetailsView);
        return "route-details";
    }
}
