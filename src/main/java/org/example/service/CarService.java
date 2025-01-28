package org.example.service;

import org.example.model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {
    void create(String carName, String carModel, String vinNumber, int carYear, String carColor) throws SQLException, ClassNotFoundException;

    Car getById(Long id) throws SQLException, ClassNotFoundException;

    List<Car> getAll() throws SQLException, ClassNotFoundException;

    void removeById(Long id) throws SQLException, ClassNotFoundException;

    Car getByVin(String vinNumber) throws SQLException, ClassNotFoundException;
}
