package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.model.view.DetailsView;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.ModelService;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ModelService modelService;
    private final ModelMapper modelMapper;
    private final BrandService brandService;

    public OfferServiceImpl(OfferRepository offerRepository, UserService userService, ModelService modelService, ModelMapper modelMapper, BrandService brandService) {
        this.offerRepository = offerRepository;
        this.userService = userService;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }

    @Override
    public void initializeOffers() {
        if (this.offerRepository.count() == 0) {
            Offer first = new Offer();
            first.setCreated(Instant.now());
            first.setEngine(Engine.GASOLINE);
            first.setImageUrl("https://automedia.investor.bg/media/files/resized/uploadedfiles/640x0/0b7/19201be17adcc420c719de6d31d760b7-01-11.jpg");
            first.setMileage(33000);
            first.setPrice(BigDecimal.valueOf(100000L));
            first.setTransmission(Transmission.AUTOMATIC);
            first.setYear(2018);
            first.setModel(this.modelService.getByName("Q8"));
            first.setSeller(this.userService.getByUserName("pesho"));

            Offer second = new Offer();
            second.setCreated(Instant.now());
            second.setEngine(Engine.GASOLINE);
            second.setImageUrl("https://parkers-images.bauersecure.com/external/cfs/usedcfs-108054561329134/706967672/450x300/1.jpg");
            second.setMileage(333000);
            second.setPrice(BigDecimal.valueOf(10000L));
            second.setTransmission(Transmission.AUTOMATIC);
            second.setYear(2005);
            second.setModel(this.modelService.getByName("CLS"));
            second.setSeller(this.userService.getByUserName("pesho"));

            this.offerRepository.saveAll(List.of(first, second));

        }

    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return this.offerRepository
                .findAll()
                .stream()
                .map(o -> {
                    OfferSummaryView view = modelMapper.map(o, OfferSummaryView.class);
                    view.setModel(o.getModel().getName());
                    view.setBrand(o.getModel().getBrand().getName());
                    return view;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addOffer(OfferBindingModel bindingModel) {


        Model model = this.modelService.createNewModel(bindingModel);


        Offer offer = this.modelMapper.map(bindingModel, Offer.class);
        offer.setModel(model);
        offer.setCreated(Instant.now());
        CurrentUser currentLoggedIn = this.userService.getCurrentUser();
        if (!currentLoggedIn.isLoggedIn()) {
            offer.setSeller(this.userService.getByUserName("Admin"));
        } else {
            offer.setSeller(this.userService.getByUserName(currentLoggedIn.getUsername()));
        }
        this.offerRepository.save(offer);

    }

    @Override
    public DetailsView getDetailsForOfferById(Long id) {
        return this.offerRepository.findById(id)
                .map(offer -> {
                    DetailsView view = modelMapper.map(offer, DetailsView.class);
                    Instant created = offer.getCreated();
                    String creationDate = created.toString().substring(0, 10);
                    creationDate += " " + created.toString().substring(11, created.toString().length() - 1);
                    view.setCreated(creationDate);
                    view.setBrand(offer.getModel().getBrand().getName());
                    view.setModel(offer.getModel().getName());
                    if (offer.getModified() != null) {
                        String modificationDate = offer.getModified().toString().substring(0, 10);
                        modificationDate += " " + offer.getModified().toString().substring(11, created.toString().length() - 1);
                        view.setModified(modificationDate);
                    }
                    return view;
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        this.offerRepository.deleteById(id);
    }

    @Override
    public DetailsView findById(Long id) {
        return this.modelMapper.map(this.offerRepository.findById(id).get(), DetailsView.class);
    }

    @Override
    public void updateOffer(OfferUpdateBindingModel updateBindingModel) {

        Offer offer = this.offerRepository.findById(updateBindingModel.getId()).get();

        offer.setYear(updateBindingModel.getYear());
        offer.setMileage(updateBindingModel.getMileage());
        offer.setPrice(updateBindingModel.getPrice());
        offer.setEngine(updateBindingModel.getEngine());
        offer.setTransmission(updateBindingModel.getTransmission());

        offer.setModified(Instant.now());
        offer.setImageUrl(updateBindingModel.getImageUrl());
        offer.setDescription(updateBindingModel.getDescription());

        this.offerRepository.save(offer);

    }
}
