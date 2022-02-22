package bg.softuni.mobilelele.model.binding;

import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;

import java.math.BigDecimal;

public class OfferUpdateBindingModel {
    private int year;
    private int mileage;
    private BigDecimal price;
    private Engine engine;
    private Transmission transmission;
    private String imageUrl;
    private String description;
    private Long id;

    public OfferUpdateBindingModel() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public OfferUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
