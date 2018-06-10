package application.controller;

import application.car.CarService;
import application.detailedSearch.CarSpec;
import application.detailedSearch.SearchService;
import application.fileHandlers.CSVCarList;
import application.session.SearchSession;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Controller
@SessionAttributes("searchSession")
@RequestMapping("/specification")
public class CarSpecController {
    private final CarService service;
    private final Map<String, Set<String>> brandsAndModels;
    private final SearchService searchService;
    private Map<String, String> offers;
    private Map<String, String> images;
    private Map<String, String> pages;



    @ModelAttribute
    public SearchSession session(){
        return new SearchSession();
    }
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
    public String postSpecifyBrand( @ModelAttribute CarSpec carSpec, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()) return "redirect:/specification/{brand}";
        Elements hrefs = searchService.getOffersLinks(carSpec);
        offers = searchService.collectCarOffers(hrefs);
        images = searchService.mapOffersImages(hrefs);
        pages = searchService.getPagesOfSearch(carSpec);
        return "redirect:/specification/{brand}/"+carSpec.getModel();
    }
    @GetMapping("/{brand}/{model}")
    public String specifyModel(Model attributes){
        attributes.addAttribute("offers",offers);
        attributes.addAttribute("images", images);
        attributes.addAttribute("pages", pages);
        return "OffersDisplay";
    }
    @RequestMapping(value = {"/{brand}/{model}","/{brand}/{model}/page"}, params = {"offer","!pages"}, method = RequestMethod.POST)
    public String postSeeOffer(@RequestParam String offer, @ModelAttribute SearchSession session){
        session.setUrl(offer);
        return "redirect:/{brand}/{model}/offer";
    }
    @RequestMapping(value ={"/{brand}/{model}","/{brand}/{model}/page"}, params = {"!offer","pages"}, method = RequestMethod.POST)
    public String postSwitchPage( @RequestParam String pages, @ModelAttribute SearchSession session) throws IOException {
        this.pages = searchService.getPagesOfSearch(pages);
        Elements hrefs = searchService.getOffersLinks(pages);
        offers = searchService.collectCarOffers(hrefs);
        images = searchService.mapOffersImages(hrefs);
        return "redirect:/specification/{brand}/{model}/page";
    }
    @GetMapping(value = "/{brand}/{model}/page")
    public String getAnotherPage(Model attributes){
        attributes.addAttribute("offers",offers);
        attributes.addAttribute("images", images);
        attributes.addAttribute("pages", pages);
        return "OffersDisplay";
    }

}
