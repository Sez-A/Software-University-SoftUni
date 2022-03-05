package com.example.pathfinder.service;

import com.example.pathfinder.model.view.RouteByCategoryView;
import com.example.pathfinder.model.view.RouteDetailsView;
import com.example.pathfinder.model.view.RouteSummaryView;

import java.util.List;

public interface RouteService {
    List<RouteSummaryView> getAllRoutes();

    RouteDetailsView findRouteById(Long id);

    List<RouteByCategoryView> findAllRoutesByCategory(String categoryName);
}
