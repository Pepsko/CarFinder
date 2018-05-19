package application.car;

import application.detailedSearch.CarSpec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class CarService {
    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public void addCar(CarDTO carDTO){
        checkNotNull(carDTO, "Car must exist");
        repository.save(toEntity(carDTO));
    }
    private CarDTO toDTO(CarEntity entity){
        return new CarDTO(entity.getId(),entity.getBrand(),entity.getModel(),entity.getHorsePower(),entity.getBodyType(),entity.getEngine(),entity.getProductionYear(),entity.getDrivetrain(),entity.getMileage(),entity.getColor());
    }

    private CarEntity toEntity(CarDTO dto){
        return new CarEntity(dto.getBrand(),dto.getModel(),dto.getHorsePower(),dto.getBodyType(), dto.getEngine(),dto.getProductionYear(),dto.getDrivetrain(),dto.getMileage(), dto.getColor());
    }

    public List<CarDTO> findAll(){
        List<CarDTO> allCars = new ArrayList<>();
        for (CarEntity car:repository.findAll()) {
            allCars.add(toDTO(car));
        }
        return allCars;
    }
    public Set<CarDTO> getCarsByBrand(String brandName){
        Set<CarDTO> set = new HashSet<>();
        for (CarEntity temp: repository.findAll()) {
            if (temp.getBrand().equals(brandName))
            set.add(toDTO(temp));
        }
        return set;
    }

    public void deleteByID(Integer id){
        repository.delete(id);
    }


    /*  public boolean carMeetsCriteria(CarSpec spec, CarDTO carDTO){
          boolean brand = spec.getBrand().equals(carDTO.getBrand());
          boolean model=true, body=true, power, productionYear, drivetrain=true, mileage, color = true;
          power = spec.getPowerFrom()<carDTO.getHorsePower() && spec.getPowerTo()>carDTO.getHorsePower();
          if(spec.getModel()!= null){
              model = spec.getModel().equals(carDTO.getModel());
          }
          if(spec.getBodyType()!=null){
              body = spec.getBodyType().equals(carDTO.getBodyType());
          }
          productionYear = spec.getProductionFrom()<carDTO.getProductionYear()&&spec.getPowerTo()>carDTO.getHorsePower();
          if(spec.getDrivetrain()!=null){
              drivetrain = spec.getDrivetrain().equals(carDTO.getDrivetrain());
          }
          mileage = spec.getMileageTo()>carDTO.getMileage();
          if(spec.getColor()!= null){
              color = spec.getColor().equals(carDTO.getColor());
          }
          return brand && model && body && power && productionYear && drivetrain && mileage && color;
      }*/
}
