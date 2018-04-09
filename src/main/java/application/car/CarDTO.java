package application.car;

import java.time.LocalDate;

public class CarDTO {

    private String brand;
    private String model;
    private Integer horsePower;
    private String engine;
    private Integer productionYear;
    private String drivetrain;
    private Integer mileage;
    private String color;

    public CarDTO(String brand, String model, Integer horsePower, String engine, Integer productionYear, String drivetrain, Integer mileage, String color) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.engine = engine;
        this.productionYear = productionYear;
        this.drivetrain = drivetrain;
        this.mileage = mileage;
        this.color = color;
    }

    public CarDTO(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarDTO() {
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Car:" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", engine='" + engine + '\'' +
                ", productionYear=" + productionYear +
                ", drivetrain='" + drivetrain + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'';
    }
}
