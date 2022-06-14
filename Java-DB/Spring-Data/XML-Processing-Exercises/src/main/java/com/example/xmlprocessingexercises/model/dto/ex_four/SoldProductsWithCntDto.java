package com.example.xmlprocessingexercises.model.dto.ex_four;

import javax.xml.bind.annotation.*;
import java.util.List;

//@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsWithCntDto {
    @XmlAttribute(name = "count")
    private Integer count;

      @XmlElement(name = "product")
    //  @XmlElementWrapper(name = "sold-products")
    private List<SoldProductWithNamePriceDto> soldProducts;

    public List<SoldProductWithNamePriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductWithNamePriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
