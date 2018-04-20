package application.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class CarService {
    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
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
        return new CarEntity(dto.getBrand(),dto.getModel(),dto.getHorsePower(),dto.getBodyType(), dto.getEngine(),dto.getProductionYear(),dto.getDrivetrain(),dto.getMileage(),dto.getColor());
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



}
