package com.example.automappingex.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetailGameDto {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public DetailGameDto() {
    }

    public DetailGameDto(String title, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s"
                , this.getTitle(), this.getPrice(), this.getDescription(), this.getReleaseDate());
    }
}
