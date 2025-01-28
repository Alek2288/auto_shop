package org.example.repository.array.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarArrayRepositoryImpl implements CarRepository {


    private final List<Car> cars = new ArrayList<>();
    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public Car findById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public void deleteById(Long id) {
        Car carForDelete = null;
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                carForDelete = car;
                break;
            }
        }
        if (carForDelete != null) {
            cars.remove(carForDelete);
        }
    }

    @Override
    public Car findByVin(String vinNumber) {
        for (Car car : cars) {
            if (car.getVinNumber().equals(vinNumber)) {
                return car;
            }
        }
        return null;
    }
}
