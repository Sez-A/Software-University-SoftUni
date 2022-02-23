package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.view.BrandsView;
import bg.softuni.mobilelele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class BrandsController {
    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/all")
    public String allBrands(Model model) {
        Set<BrandsView> brandViews = this.brandService.getAllBrands();
        model.addAttribute("brandViews", brandViews);
        return "brands";
    }
}
