package com.example.pathfinder.model.service;

import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class AddRouteServiceModel {
    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private LevelEnum level;
    private String videoUrl;
    private Set<CategoryNamesEnum> categories;

    public String getName() {
        return name;
    }

    public AddRouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddRouteServiceModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public AddRouteServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNamesEnum> getCategories() {
        return categories;
    }

    public AddRouteServiceModel setCategories(Set<CategoryNamesEnum> categories) {
        this.categories = categories;
        return this;
    }
}
