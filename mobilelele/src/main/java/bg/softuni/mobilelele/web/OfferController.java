package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.view.DetailsView;
import bg.softuni.mobilelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/add")
    public String offers() {
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(OfferBindingModel bindingModel) {

        offerService.addOffer(bindingModel);
        return "redirect:/";
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable Long id, Model model) {
        DetailsView detailsView = this.offerService.getDetailsForOfferById(id);
        model.addAttribute("details", detailsView);
        return "details";
    }

    @DeleteMapping("/offers/{id}")
    public String delete(@PathVariable Long id) {
        offerService.deleteById(id);
        return "redirect:/offers/all";
    }
}
