package com.example.xmlprocessingexercises.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductsCountDescRootDto {
    @XmlElement(name = "category")
    private List<CategoryWithProductsInfoDto> category;

    public List<CategoryWithProductsInfoDto> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryWithProductsInfoDto> category) {
        this.category = category;
    }
}
