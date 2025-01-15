package model;

public class Car {
    private String CarName;
    private String CarModel;
    private int CarYear;
    private String VinNumber;
    private String CarColor;

    public Car() {
    }

    public Car(String carName, String carModel, int carYear, String vinNumber, String carColor) {
        CarName = carName;
        CarModel = carModel;
        CarYear = carYear;
        VinNumber = vinNumber;
        CarColor = carColor;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    public int getCarYear() {
        return CarYear;
    }

    public void setCarYear(int carYear) {
        CarYear = carYear;
    }

    public String getVinNumber() {
        return VinNumber;
    }

    public void setVinNumber(String vinNumber) {
        VinNumber = vinNumber;
    }

    public String getCarColor() {
        return CarColor;
    }

    public void setCarColor(String carColor) {
        CarColor = carColor;
    }
}
