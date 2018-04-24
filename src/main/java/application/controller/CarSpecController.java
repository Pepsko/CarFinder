package application.controller;

import application.car.CarDTO;
import application.car.CarService;
import application.car.CarSpec;
import application.fileHandlers.CSVCarList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/specification")
public class CarSpecController {
    private final CarService service;
    private final Map<String, Set<String>> brandsAndModels;

    @ModelAttribute
    public CarSpec defaultCar(){
        return new CarSpec("brand");
    }

    public CarSpecController(CarService service) throws Exception {
        this.service = service;
        this.brandsAndModels = CSVCarList.readAndMapFile();
    }

    @GetMapping("")
    public String specify(Model model) {
        model.addAttribute("brands",brandsAndModels);
        return "carSpecification";
    }
    @PostMapping("")
    public String postSpecify(@ModelAttribute CarSpec carSpec, BindingResult bindingResult, @RequestParam String submit){
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
    public String postSpecifyBrand(@PathVariable String brand, @ModelAttribute CarSpec carSpec, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "redirect:/specification/{brand}";
        return "redirect:/specification/{brand}/"+carSpec.getModel();
    }
    @GetMapping("/{brand}/{model}")
    public String specifyModel(@PathVariable String brand, @PathVariable String model, Model attributes){
        attributes.addAttribute("brand", brand);
        attributes.addAttribute("models", model);
        return "carSpecification";
    }
}
