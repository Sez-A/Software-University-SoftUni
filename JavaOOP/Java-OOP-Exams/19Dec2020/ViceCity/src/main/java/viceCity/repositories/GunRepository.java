package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GunRepository implements Repository<Gun> {
    List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        for (Gun gun : models) {
            if (gun.getName().equals(model.getName())) {
                return;
            }
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : models) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
