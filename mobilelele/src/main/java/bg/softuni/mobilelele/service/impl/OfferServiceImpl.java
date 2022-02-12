package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.Offer;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.model.view.OfferSummaryView;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.service.ModelService;
import bg.softuni.mobilelele.service.OfferService;
import bg.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, UserService userService, ModelService modelService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.userService = userService;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
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
            first.setSeller(this.userService.getByFirstName("pesho"));

            Offer second = new Offer();
            second.setCreated(Instant.now());
            second.setEngine(Engine.GASOLINE);
            second.setImageUrl("https://parkers-images.bauersecure.com/external/cfs/usedcfs-108054561329134/706967672/450x300/1.jpg");
            second.setMileage(333000);
            second.setPrice(BigDecimal.valueOf(10000L));
            second.setTransmission(Transmission.AUTOMATIC);
            second.setYear(2005);
            second.setModel(this.modelService.getByName("CLS"));
            second.setSeller(this.userService.getByFirstName("pesho"));

            this.offerRepository.saveAll(List.of(first, second));

        }

    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return this.offerRepository
                .findAll()
                .stream()
                .map(o -> modelMapper.map(o, OfferSummaryView.class))
                .collect(Collectors.toList());
    }
}
