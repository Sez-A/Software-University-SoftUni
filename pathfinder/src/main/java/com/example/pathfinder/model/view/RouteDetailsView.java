package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.enums.LevelEnum;

import java.util.HashSet;
import java.util.Set;


public class RouteDetailsView {
    private Long id;
    private String authorName;
    private LevelEnum level;
    private String description;
    private String videoUrl;
    private Set<String> pictureUrls;

    public RouteDetailsView() {
        this.pictureUrls = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public RouteDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public RouteDetailsView setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteDetailsView setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsView setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<String> getPictureUrls() {
        return pictureUrls;
    }

    public RouteDetailsView setPictureUrls(Set<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
        return this;
    }

    public void setPictureUrl(String url) {
        this.pictureUrls.add(url);
    }
}
