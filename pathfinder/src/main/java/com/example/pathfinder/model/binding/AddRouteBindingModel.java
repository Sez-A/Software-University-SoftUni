package com.example.pathfinder.model.binding;

import com.example.pathfinder.model.entity.enums.CategoryNamesEnum;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class AddRouteBindingModel {
    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private LevelEnum level;
    private String videoUrl;
    private Set<CategoryNamesEnum> categories;

    @Size(min = 5, max = 20)
    public String getName() {
        return name;
    }

    public AddRouteBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public AddRouteBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }


    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public AddRouteBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public AddRouteBindingModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    @Size(max = 11)
    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNamesEnum> getCategories() {
        return categories;
    }

    public AddRouteBindingModel setCategories(Set<CategoryNamesEnum> categories) {
        this.categories = categories;
        return this;
    }
}
