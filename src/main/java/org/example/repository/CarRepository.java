package org.example.repository;

import org.example.model.Car;

import java.util.List;

public interface CarRepository {
    Car save(Car car);

    Car findById(Long id);

    List<Car> findAll();

    void deleteById(Long id);

    Car findByVin(String vinNumber);

}
