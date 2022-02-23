package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.Brand;
import bg.softuni.mobilelele.model.view.BrandsView;

import java.util.Set;

public interface BrandService {
    void initializeBrands();

    Brand getByName(String name);

    void saveBrand(Brand brand);

    boolean containsBrand(String name);

    Brand createNewBrand(String name);

    Set<BrandsView> getAllBrands();
}
