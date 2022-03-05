package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
   @Query(value = "SELECT * FROM routes " +
           "JOIN routes_categories rc on routes.id = rc.route_id " +
           "JOIN categories c on c.id = rc.categories_id " +
           "WHERE c.name LIKE :name", nativeQuery = true)
   List<Route> findAllRoutesByCategory(@Param("name") String name);

}
