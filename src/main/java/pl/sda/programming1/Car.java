package pl.sda.programming1;


import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private final String brandName;
    private final String modelName;
    private final int productionYear;
    private final int powerInKM;
    private final BigDecimal carPrice;
    private final String versionOfEquipment;

    public Car(String brandName, String modelName, int productionYear, int powerInKM, BigDecimal carPrice, String versionOfCar) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.productionYear = productionYear;
        this.powerInKM = powerInKM;
        this.carPrice = carPrice;
        this.versionOfEquipment = versionOfCar;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getPowerInKM() {
        return powerInKM;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public String getVersionOfEquipment() {
        return versionOfEquipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return productionYear == car.productionYear &&
                powerInKM == car.powerInKM &&
                Objects.equals(brandName, car.brandName) &&
                Objects.equals(modelName, car.modelName) &&
                Objects.equals(carPrice, car.carPrice) &&
                Objects.equals(versionOfEquipment, car.versionOfEquipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, productionYear, powerInKM, carPrice, versionOfEquipment);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", productionYear=" + productionYear +
                ", powerInKM=" + powerInKM +
                ", carPrice=" + carPrice +
                ", versionOfEquipment='" + versionOfEquipment + '\'' +
                '}';
    }
}
