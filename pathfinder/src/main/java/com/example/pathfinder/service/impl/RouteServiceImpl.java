package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.Pictures;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;
import com.example.pathfinder.model.service.AddRouteServiceModel;
import com.example.pathfinder.model.view.RouteByCategoryView;
import com.example.pathfinder.model.view.RouteDetailsView;
import com.example.pathfinder.model.view.RouteSummaryView;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CategoriesService;
import com.example.pathfinder.service.PictureService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final CategoriesService categoriesService;
    private final UserService userService;
    private final PictureService pictureService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, CategoriesService categoriesService,
                            UserService userService, PictureService pictureService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.categoriesService = categoriesService;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @Override
    public List<RouteSummaryView> getAllRoutes() {
        List<RouteSummaryView> collect = this.routeRepository.findAll()
                .stream()
                .map(route -> {
                    RouteSummaryView view = this.modelMapper.map(route, RouteSummaryView.class);
                    if(route.getPictures().isEmpty()) {
                        view.setPictureUrl("http://res.cloudinary.com/ch-cloud/image/upload/v1630581418/tqhjrinmsb69ev7upg0q.jpg");
                    }else {
                        view.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                    }

                    return view;
                })
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public RouteDetailsView findRouteById(Long id) {
        Route route = this.routeRepository.findById(id).orElse(null);

        RouteDetailsView routeDetailsView = this.modelMapper.map(route, RouteDetailsView.class);
        routeDetailsView.setAuthorName(route.getAuthor().getUsername());

        for (Pictures picture : route.getPictures()) {
            routeDetailsView.setPictureUrl(picture.getUrl());
        }


        return routeDetailsView;
    }

    @Override
    public List<RouteByCategoryView> findAllRoutesByCategory(String categoryName) {

        return this.routeRepository.findAllRoutesByCategory(categoryName)
                .stream()
                .map(route -> {
                    RouteByCategoryView routeByCategoryView = this.modelMapper.map(route, RouteByCategoryView.class);
                    routeByCategoryView.setTitle(route.getName());
                    routeByCategoryView.setImageUrl(route.getPictures().stream().findFirst().get().getUrl());
                    return routeByCategoryView;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addRoute(AddRouteServiceModel addRouteServiceModel) throws IOException {
        Route route = this.modelMapper.map(addRouteServiceModel, Route.class);

       // TODO set the current logged in user as author of route
        route.setGpxCoordinates(new String(addRouteServiceModel
                .getGpxCoordinates().getBytes()));

        Set<Categories> categories = new HashSet<>();
        for (CategoryNamesEnum name : addRouteServiceModel.getCategories()) {
            categories.add(this.categoriesService.findByName(name));
        }
        route.setCategories(categories);
        this.routeRepository.save(route);
    }
}
