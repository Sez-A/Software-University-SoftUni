package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.view.DetailsView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    void addOffer(OfferBindingModel bindingModel);

    DetailsView getDetailsForOfferById(Long id);

    void deleteById(Long id);

    DetailsView findById(Long id);
}
