package carShop;

import java.io.Serializable;

public interface Car extends Serializable {
    Integer TIERS = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
