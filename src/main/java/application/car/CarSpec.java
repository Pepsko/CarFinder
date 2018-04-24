package application.car;

public class CarSpec {
    private String brand;
    private String model;
    private Integer powerFrom;
    private Integer powerTo;
    private String bodyType;
    private Integer productionFrom;
    private Integer productionTo;
    private Integer maxMileage;
    private String drivetrain;
    private String color;

    public CarSpec(String brand, String model, Integer powerFrom, Integer powerTo, String bodyType, Integer productionFrom, Integer productionTo, Integer mileageFrom,  String color) {
        this.brand = brand;
        this.model = model;
        this.powerFrom = powerFrom;
        this.powerTo = powerTo;
        this.bodyType = bodyType;
        this.productionFrom = productionFrom;
        this.productionTo = productionTo;
        this.maxMileage = mileageFrom;
        this.color = color;
    }

    public CarSpec(String brand) {
        this.brand = brand;
    }

    public CarSpec() {
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
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

    public Integer getPowerFrom() {
        return powerFrom;
    }

    public void setPowerFrom(Integer powerFrom) {
        this.powerFrom = powerFrom;
    }

    public Integer getPowerTo() {
        return powerTo;
    }

    public void setPowerTo(Integer powerTo) {
        this.powerTo = powerTo;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Integer getProductionFrom() {
        return productionFrom;
    }

    public void setProductionFrom(Integer productionFrom) {
        this.productionFrom = productionFrom;
    }

    public Integer getProductionTo() {
        return productionTo;
    }

    public void setProductionTo(Integer productionTo) {
        this.productionTo = productionTo;
    }

    public Integer getMaxMileage() {
        return maxMileage;
    }

    public void setMaxMileage(Integer maxMileage) {
        this.maxMileage = maxMileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
