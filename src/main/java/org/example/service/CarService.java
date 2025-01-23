package org.example.service;

import org.example.model.Car;

import java.util.List;

public interface CarService {
    Car create(String carName, String carModel, String vinNumber, int carYear, String carColor);

    Car getById(Long id);

    List<Car> getAll();

    void removeById(Long id);

    Car getByVin(String vinNumber);
}
