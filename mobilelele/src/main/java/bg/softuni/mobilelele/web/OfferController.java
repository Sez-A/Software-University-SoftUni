package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.binding.OfferBindingModel;
import bg.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.model.view.DetailsView;
import bg.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;

@Controller
public class OfferController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
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

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model) {
        DetailsView detailsView = offerService.findById(id);
        OfferUpdateBindingModel offerUpdateBindingModel = modelMapper.map(detailsView, OfferUpdateBindingModel.class);
        model.addAttribute("offerUpdateBindingModel", offerUpdateBindingModel);
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, OfferUpdateBindingModel offerModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {


        System.out.println(Instant.now());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel"
                    , bindingResult);

            return "redirect:/offers/" + id + "/details";
        }

        offerService.updateOffer(offerModel);

        return "redirect:/offers/" + id + "/details";
    }
}
