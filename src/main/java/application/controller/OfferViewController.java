package application.controller;

import application.detailedSearch.OfferDisplayService;
import application.session.SearchSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;

@Controller
@SessionAttributes("searchSession")
public class OfferViewController {

    @ModelAttribute
    public SearchSession session(){
        return new SearchSession();
    }
    @GetMapping("{brand}/{model}/offer")
    public String getOfferView(@ModelAttribute SearchSession session, Model model) throws IOException {
        OfferDisplayService displayService = new OfferDisplayService(session.getUrl());
        model.addAttribute("price", displayService.getOffersPrice());
        model.addAttribute("features", displayService.getCarFeatures());
        model.addAttribute("photos", displayService.getMainCarPhotosWithThumbs());
        model.addAttribute("description", displayService.getFullDescription());
        model.addAttribute("params", displayService.getCarParameters());
        return "OfferView";
    }

}
