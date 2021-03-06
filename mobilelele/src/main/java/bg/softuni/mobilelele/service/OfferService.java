package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.view.DetailsView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    void addOffer(OfferBindingModel bindingModel, String userName);

    DetailsView getDetailsForOfferById(Long id);

    void deleteById(Long id);

    boolean isOwner(String userName, Long id);

    DetailsView findById(Long id);

    void updateOffer(OfferUpdateBindingModel updateBindingModel);
}
