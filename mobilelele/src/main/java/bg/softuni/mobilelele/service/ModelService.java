package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.Model;

public interface ModelService {
    void initializeModels();

    Model getByName(String name);
}
