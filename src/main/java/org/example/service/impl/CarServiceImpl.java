package org.example.service.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.repository.db.impl.CarDBRepositoryImpl;
import org.example.service.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository = new CarDBRepositoryImpl();

    @Override
    public void create(String carName, String carModel, String vinNumber, int carYear, String carColor) throws SQLException, ClassNotFoundException {
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
        Car car = new Car(carName, carModel, vinNumber, carYear, carColor);
        carRepository.save(car);
    }

    @Override
    public Car getById(Long id) throws SQLException, ClassNotFoundException {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAll() throws SQLException, ClassNotFoundException {
        return carRepository.findAll();
    }

    @Override
    public void removeById(Long id) throws SQLException, ClassNotFoundException {
        carRepository.deleteById(id);
    }

    @Override
    public Car getByVin(String vinNumber) throws SQLException, ClassNotFoundException {
        return carRepository.findByVin(vinNumber);
    }
}
