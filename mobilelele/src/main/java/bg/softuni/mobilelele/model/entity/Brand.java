package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{
    private String name;
    private Set<Model> models;
    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    public Set<Model> getModels() {
        return models;
    }

    public Brand setModels(Set<Model> models) {
        this.models = models;
        return this;
    }
}
