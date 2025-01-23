package org.example.repository.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {


    private final List<Car> cars = new ArrayList<>();
    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
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
}
