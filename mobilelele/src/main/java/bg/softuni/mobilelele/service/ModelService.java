package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.entity.Model;

public interface ModelService {
    void initializeModels();

    Model getByName(String name);

    Model createNewModel(OfferBindingModel bindingModel);
}
