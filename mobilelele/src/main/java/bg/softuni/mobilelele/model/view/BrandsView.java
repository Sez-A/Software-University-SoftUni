package bg.softuni.mobilelele.model.view;

import java.util.Set;

public class BrandsView {
    private String name;
    private Set<ModelView> models;

    public String getName() {
        return name;
    }

    public BrandsView setName(String name) {
        this.name = name;
        return this;
    }

    public Set<ModelView> getModels() {
        return models;
    }

    public BrandsView setModels(Set<ModelView> models) {
        this.models = models;
        return this;
    }
}
