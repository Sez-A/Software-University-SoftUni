package com.example.xmlprocessingexercises.model.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryWithProductsInfoDto {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "products-count")
    private Integer productsCount;
    @XmlElement(name = "average-price")
    private String averagePrice;
    @XmlElement(name = "total-revenue")
    private String totalRevenue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Integer getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }
}
