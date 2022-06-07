package bg.codexio.customOrmDemo.entity;

import ormFramework.annotation.Column;
import ormFramework.annotation.Entity;
import ormFramework.annotation.Id;

@Entity(tableName = "towns")
public class Town {
    @Id
    private int id;
    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;
    @Column(name = "address", columnDefinition = "VARCHAR(100)")
    private String address;
    @Column(name = "postcode", columnDefinition = "VARCHAR(20)")
    private String postcode;
    @Column(name = "demo", columnDefinition = "VARCHAR(20)")
    private String demo;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Town() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
