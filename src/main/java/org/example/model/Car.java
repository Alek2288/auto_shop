package org.example.model;

public class Car {
    private String carName;
    private String carModel;
    private int carYear;
    private String vinNumber;
    private String carColor;
    private Long id;

    public Car(Long id, String carName, String carModel, String vinNumber, int carYear, String carColor) {
        this.carName = carName;
        this.carModel = carModel;
        this.carYear = carYear;
        this.vinNumber = vinNumber;
        this.carColor = carColor;
        this.id = id;

    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (long) id;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarName='" + carName + '\'' +
                ", CarModel='" + carModel + '\'' +
                ", CarYear=" + carYear +
                ", VinNumber='" + vinNumber + '\'' +
                ", CarColor='" + carColor + '\'' +
                ", Id=" + id +
                '}';
    }
}
