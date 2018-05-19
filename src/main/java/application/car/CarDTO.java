package application.car;

public class CarDTO {

    private Integer id;
    private String brand;
    private String model;
    private Integer horsePower;
    private String bodyType;
    private String engine;
    private Integer productionYear;
    private String drivetrain;
    private Integer mileage;
  //  private String fuel;
    private String color;
    private String url;

    public CarDTO(Integer id, String brand, String model, Integer horsePower, String bodyType, String engine, Integer productionYear, String drivetrain, Integer mileage, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.bodyType = bodyType;
        this.engine = engine;
        this.productionYear = productionYear;
        this.drivetrain = drivetrain;
        this.mileage = mileage;
       // this.fuel = fuel;
        this.color = color;
    }

    public CarDTO(Integer id, String brand, String model, Integer horsePower, String bodyType, String engine, Integer productionYear, String drivetrain, Integer mileage, String color, String url) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.bodyType = bodyType;
        this.engine = engine;
        this.productionYear = productionYear;
        this.drivetrain = drivetrain;
        this.mileage = mileage;
        this.color = color;
        this.url = url;
    }

    public CarDTO(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public CarDTO(String brand) {
        this.brand = brand;
    }

    public CarDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
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
