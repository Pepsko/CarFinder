package application.controller;

import application.car.CarService;
import application.detailedSearch.CarSpec;
import application.detailedSearch.SearchService;
import application.fileHandlers.CSVCarList;
import application.fileHandlers.HTMLParser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/specification")
public class CarSpecController {
    private final CarService service;
    private final Map<String, Set<String>> brandsAndModels;
    private final SearchService searchService;
    private Map<String, String> offers;
    private Map<String, String> images;

    @ModelAttribute
    public CarSpec defaultCar(){
        return new CarSpec("brand");
    }

    public CarSpecController(CarService service, SearchService searchService) throws Exception {
        this.service = service;
        this.searchService = searchService;
        this.brandsAndModels = CSVCarList.readAndMapFile();
    }

    @GetMapping("")
    public String specify(Model model) {
        model.addAttribute("brands",brandsAndModels);
        return "carSpecification";
    }
    @PostMapping("")
    public String postSpecify(@ModelAttribute CarSpec carSpec, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "redirect:/specification";
        return "redirect:/specification/"+carSpec.getBrand();
    }

    @GetMapping("/{brand}")
    public String specifyBrand(@PathVariable String brand, Model model){
        model.addAttribute("brand",brand);
        model.addAttribute("models",brandsAndModels.get(brand));
        return "carSpecification";
    }
    @PostMapping("/{brand}")
    public String postSpecifyBrand(@PathVariable String brand, @ModelAttribute CarSpec carSpec, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()) return "redirect:/specification/{brand}";
        Elements hrefs = HTMLParser.getOffersLinksFromUrl(searchService.getSearchUrlBySpec(carSpec));
        offers = searchService.collectCarOffers(hrefs);
        images = searchService.mapOffersImages(hrefs);
        return "redirect:/specification/{brand}/"+carSpec.getModel();
    }
    @GetMapping("/{brand}/{model}")
    public String specifyModel(/*@PathVariable String brand, @PathVariable String model, */Model attributes){
        //attributes.addAttribute("brand", brand);
        //attributes.addAttribute("models", model);
        attributes.addAttribute("offers",offers);
        attributes.addAttribute("images", images);
        return "OffersDisplay";
    }
   /* @PostMapping("/{brand}/{model}")
    public String postSpecifyModel(@PathVariable String brand, @PathVariable String model, @ModelAttribute CarSpec carSpec,
                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "redirect:/specification/{brand}/{model}";
        return "test";
    }*/
}
