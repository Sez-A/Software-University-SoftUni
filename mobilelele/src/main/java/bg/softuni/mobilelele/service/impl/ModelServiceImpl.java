package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.model.entity.enums.Category;
import bg.softuni.mobilelele.model.entity.Model;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.service.BrandService;
import bg.softuni.mobilelele.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeModels() {
        if (this.modelRepository.count() == 0) {
            Model q8 = new Model();
            q8.setCreated(Instant.now());
            q8.setCategory(Category.CAR);
            q8.setImageUrl("https://automedia.investor.bg/media/files/resized/uploadedfiles/640x0/0b7/19201be17adcc420c719de6d31d760b7-01-11.jpg");
            q8.setName("Q8");
            q8.setStartYear(2018);
            q8.setBrand(this.brandService.getByName("Audi"));

            Model cls = new Model();

            cls.setCreated(Instant.now());
            cls.setCategory(Category.CAR);
            cls.setName("CLS");
            cls.setImageUrl("https://parkers-images.bauersecure.com/external/cfs/usedcfs-108054561329134/706967672/450x300/1.jpg");
            cls.setStartYear(2005);
            cls.setBrand(this.brandService.getByName("Mercedes-Benz"));

            this.modelRepository.saveAll(List.of(q8, cls));
        }
    }

    @Override
    public Model getByName(String name) {
        return this.modelRepository.findByName(name);
    }

    @Override
    public Model createNewModel(OfferBindingModel bindingModel) {
        Brand brand = this.brandService.getByName(bindingModel.getBrand());
        if(brand == null) {
            brand = this.brandService.createNewBrand(bindingModel.getBrand());
        }

        Model model = this.modelMapper.map(bindingModel, Model.class);

        model.setBrand(this.brandService.getByName(brand.getName()));
        model.setStartYear(bindingModel.getYear());
        model.setCreated(Instant.now());
        model.setName(bindingModel.getModel());
        return this.modelRepository.save(model);
    }
}
