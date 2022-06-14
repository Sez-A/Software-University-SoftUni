package com.example.xmlprocessingexercises.model.dto.ex_four;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsRootDto {
    @XmlAttribute(name = "count")
    private Integer count;
    @XmlElement(name = "user")
    private List<UserWithSoldProductsDto> users;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UserWithSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductsDto> users) {
        this.users = users;
    }
}
