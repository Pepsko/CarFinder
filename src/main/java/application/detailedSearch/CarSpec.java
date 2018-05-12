package application.detailedSearch;

public class CarSpec {
    private String brand="";
    private String model="";
    private String powerFrom="";
    private String powerTo="";
    private String bodyType="";
    private String productionFrom="";
    private String productionTo="";
    private String mileageFrom="";
    private String mileageTo="";
    private String drivetrain="";
    private String color="";

    public CarSpec(String brand, String model, String powerFrom, String powerTo, String bodyType, String productionFrom, String productionTo, String mileageFrom, String color) {
        this.brand = brand;
        this.model = model;
        this.powerFrom = powerFrom;
        this.powerTo = powerTo;
        this.bodyType = bodyType;
        this.productionFrom = productionFrom;
        this.productionTo = productionTo;
        this.mileageTo = mileageFrom;
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

    public String getMileageFrom() {
        return mileageFrom;
    }

    public void setMileageFrom(String mileageFrom) {
        this.mileageFrom = mileageFrom;
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

    public String getPowerFrom() {
        return powerFrom;
    }

    public void setPowerFrom(String powerFrom) {
        this.powerFrom = powerFrom;
    }

    public String getPowerTo() {
        return powerTo;
    }

    public void setPowerTo(String powerTo) {
        this.powerTo = powerTo;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getProductionFrom() {
        return productionFrom;
    }

    public void setProductionFrom(String productionFrom) {
        this.productionFrom = productionFrom;
    }

    public String getProductionTo() {
        return productionTo;
    }

    public void setProductionTo(String productionTo) {
        this.productionTo = productionTo;
    }

    public String getMileageTo() {
        return mileageTo;
    }

    public void setMileageTo(String mileageTo) {
        this.mileageTo = mileageTo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarSpec{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", powerFrom='" + powerFrom + '\'' +
                ", powerTo='" + powerTo + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", productionFrom='" + productionFrom + '\'' +
                ", productionTo='" + productionTo + '\'' +
                ", mileageFrom='" + mileageFrom + '\'' +
                ", mileageTo='" + mileageTo + '\'' +
                ", drivetrain='" + drivetrain + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
