package com.example.pathfinder.model.view;

public class RouteByCategoryView {
    private String title;
    private String description;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public RouteByCategoryView setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteByCategoryView setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RouteByCategoryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
