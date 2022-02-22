package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.view.RouteSummaryView;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteSummaryView> getAllRoutes() {
        return this.routeRepository.findAll()
                .stream()
                .map(route -> {
                    RouteSummaryView view = this.modelMapper.map(route, RouteSummaryView.class);
                    view.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());

                    return view;
                })
                .collect(Collectors.toList());
    }
}
