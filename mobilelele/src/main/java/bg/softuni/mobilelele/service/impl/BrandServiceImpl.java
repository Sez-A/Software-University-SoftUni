package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.model.view.BrandsView;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrands() {
        if (this.brandRepository.count() == 0) {
            Brand audi = new Brand();
            audi.setName("Audi");
            audi.setCreated(Instant.now());

            Brand mercedesBenz = new Brand();
            mercedesBenz.setName("Mercedes-Benz");
            mercedesBenz.setCreated(Instant.now());

            this.brandRepository.saveAll(List.of(audi, mercedesBenz));
        }
    }

    @Override
    public Brand getByName(String name) {
        return this.brandRepository.findByName(name);
    }

    @Override
    public void saveBrand(Brand brand) {
        this.brandRepository.save(brand);
    }

    @Override
    public boolean containsBrand(String name) {
        return this.brandRepository.findByName(name) == null;
    }

    @Override
    public Brand createNewBrand(String name) {
        Brand brand = new Brand();
        brand.setName(name);
        brand.setCreated(Instant.now());
        return this.brandRepository.save(brand);
    }

    @Override
    public Set<BrandsView> getAllBrands() {
        List<Brand> all = this.brandRepository.findAll();
        Set<BrandsView> brandsViews = new HashSet<>();
        for (Brand brand : all) {
            brandsViews.add(this.modelMapper.map(brand, BrandsView.class));
        }

        return brandsViews;
    }
}
