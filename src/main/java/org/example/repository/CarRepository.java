package org.example.repository;

import org.example.model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarRepository {
    void save(Car car) throws SQLException, ClassNotFoundException;

    Car findById(Long id) throws ClassNotFoundException, SQLException;

    List<Car> findAll() throws ClassNotFoundException, SQLException;

    void deleteById(Long id) throws ClassNotFoundException, SQLException;

    Car findByVin(String vinNumber) throws ClassNotFoundException, SQLException;

}
