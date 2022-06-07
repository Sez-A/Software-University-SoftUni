package problem4;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Medicament extends BaseEntity {
    private String name;

    @Column
    public String getName() {
        return name;
    }

    public Medicament setName(String name) {
        this.name = name;
        return this;
    }
}
