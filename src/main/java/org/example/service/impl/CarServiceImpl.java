package org.example.service.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.repository.impl.CarRepositoryImpl;
import org.example.service.CarService;
import org.example.utils.AutoIncrement;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository = new CarRepositoryImpl();

    @Override
    public Car create(String carModel, String carName, String vinNumber, int carYear, String carColor) {
        Long id = AutoIncrement.getId();
        if (carName.isEmpty()) {
            throw new RuntimeException("Марка машины не может быть пустой");
        }
        if (carModel.isEmpty()) {
            throw new RuntimeException("Модель не может быть пуста");
        }
        if (carColor.isEmpty()) {
            throw new RuntimeException("Цвет не может быть пуст");
        }
        if (carYear < 1960 || carYear > 2025) {
            throw new RuntimeException("Напишите корректный возраст");
        }
        if (vinNumber.length() != 17) {
            throw new RuntimeException("Vin содержит 17 знаков");
        }
        Car car = new Car(id, carModel, carName, vinNumber, carYear, carColor);
        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void removeById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car getByVin(String vinNumber) {
        return null;
    }
}
