package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.Comments;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.view.CommentViewModel;
import com.example.pathfinder.repository.CommentRepository;
import com.example.pathfinder.service.CommentService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final RouteService routeService;

    public CommentServiceImpl(RouteService routeService) {
        this.routeService = routeService;

    }

    @Transactional
    @Override
    public List<CommentViewModel> getCommentsByRoute(Long routeId) {
        Optional<Route> routeOpt = routeService.findOptionalRouteById(routeId);
        if (routeOpt.isEmpty()) {
            throw new ObjectNotFoundException("Route with id " + routeId + "was not found!");
        }

        return routeOpt
                .get()
                .getComments()
                .stream()
                .map(this::mapToCommentView)
                .collect(Collectors.toList());
    }

    private CommentViewModel mapToCommentView(Comments comment) {
        return new CommentViewModel()
                .setCommentId(comment.getId())
                .setCreated(comment.getCreated())
                .setCanApprove(true)
                .setCanDelete(true)
                .setMessage(comment.getTextContent())
                .setUser(comment.getAuthor().getUsername());
    }
}
