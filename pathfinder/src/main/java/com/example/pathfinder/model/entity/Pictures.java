package com.example.pathfinder.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Pictures extends BaseEntity{
    private String title;
    private String url;
    private User author;
    private Route route;


    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
