package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.enums.LevelEnum;
import com.example.pathfinder.model.service.AddRouteServiceModel;
import com.example.pathfinder.model.view.RouteByCategoryView;
import com.example.pathfinder.model.view.RouteDetailsView;
import com.example.pathfinder.model.view.RouteSummaryView;

import java.io.IOException;
import java.util.List;

public interface RouteService {
    List<RouteSummaryView> getAllRoutes();

    RouteDetailsView findRouteById(Long id);

    List<RouteByCategoryView> findAllRoutesByCategory(String categoryName);

    void addRoute(AddRouteServiceModel addRouteServiceModel) throws IOException;
}
