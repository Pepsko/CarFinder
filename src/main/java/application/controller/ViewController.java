package application.controller;

import application.car.CarDTO;
import application.car.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

/**
 * Created by Lenovo on 2018-03-26.
 */
@Controller
public class ViewController {

    private final CarService service;

    @ModelAttribute
    public CarDTO defaultCar(){
        return new CarDTO("brand", "model");
    }

    public ViewController(CarService service) {
        this.service = service;
    }

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("cars",service.findAll());
        return "test";
    }
    @PostMapping("")
    public String add(Model model, @ModelAttribute CarDTO carDTO, BindingResult bindingResult, @RequestParam String submit){
        if(bindingResult.hasErrors()) return "redirect:";
        service.addCar(carDTO);
        return "BrandSearch";
    }
    @GetMapping("/{brand}")
    public String searchByBrand(Model model, @PathVariable String brand){
        model.addAttribute("brand",service.getCarsByBrand(brand));
        return "BrandSearch";
    }
}
