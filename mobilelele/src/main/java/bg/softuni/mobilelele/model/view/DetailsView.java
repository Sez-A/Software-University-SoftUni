package bg.softuni.mobilelele.model.view;

import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;

import java.math.BigDecimal;
import java.time.Instant;

public class DetailsView {
    private int mileage;
    private BigDecimal price;
    private Engine engine;
    private Transmission transmission;
    private String created;
    private String modified;
    private String sellerFirstName;
    private String sellerLastName;
    private String imageUrl;

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
}
