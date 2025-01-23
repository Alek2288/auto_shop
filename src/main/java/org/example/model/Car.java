package org.example.model;

public class Car {
    private String CarName;
    private String CarModel;
    private int CarYear;
    private String VinNumber;
    private String CarColor;
    private Long Id;

    public Car(Long id, String carModel, String carName, String carColor, int carYear, String vinNumber) {
    }

    public Car(String carName, String carModel, int carYear, String vinNumber, String carColor, int id) {
        CarName = carName;
        CarModel = carModel;
        CarYear = carYear;
        VinNumber = vinNumber;
        CarColor = carColor;
        Id = (long) id;

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

    public Long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = (long) id;
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
