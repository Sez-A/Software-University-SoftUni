package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;

import java.math.BigDecimal;
import java.time.Instant;

public class DetailsView {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private BigDecimal price;
    private Engine engine;
    private Transmission transmission;
    private String created;
    private String modified;
    private String sellerFirstName;
    private String sellerLastName;
    private String userNameOfSeller;
    private String imageUrl;
    private String description;
    private Long id;

    public int getMileage() {
        return mileage;
    }

    public DetailsView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public DetailsView setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public DetailsView setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }


    public String getModified() {
        return modified;
    }

    public DetailsView setModified(String modified) {
        this.modified = modified;
        return this;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public DetailsView setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
        return this;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public DetailsView setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
        return this;
    }

    public String getUserNameOfSeller() {
        return userNameOfSeller;
    }

    public DetailsView setUserNameOfSeller(String userNameOfSeller) {
        this.userNameOfSeller = userNameOfSeller;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public DetailsView setCreated(String created) {
        this.created = created;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public DetailsView setDescription(String description) {
        this.description = description;
        return this;
    }
}
