package org.example.repository.db.impl;

import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.repository.db.DatabaseMain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDBRepositoryImpl implements CarRepository {

    private final DatabaseMain databaseMain = new DatabaseMain("//localhost:1234/auto_shop","postgres","1234");


    @Override
    public void save(Car car) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO autos (car_name, car_model, car_year, vin_number, car_color) VALUES (?, ?, ?, ?, ?)";
        Class.forName("org.postgresql.Driver");
        Connection connection = databaseMain.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, car.getCarName());
        preparedStatement.setString(2, car.getCarModel());
        preparedStatement.setInt(3, car.getCarYear());
        preparedStatement.setString(4, car.getVinNumber());
        preparedStatement.setString(5, car.getCarColor());
        preparedStatement.execute();
        connection.close();
    }

    @Override
    public Car findById(Long id) throws ClassNotFoundException, SQLException {
        Car car = new Car();
        String query = "SELECT * FROM autos WHERE id = ?";
        Class.forName("org.postgresql.Driver");
        Connection connection = databaseMain.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Long idFromDB = resultSet.getLong("id");
            String carName = resultSet.getString("car_name");
            String carModel = resultSet.getString("car_model");
            int carYear = resultSet.getInt("car_year");
            String vinNumber = resultSet.getString("vin_number");
            String carColor = resultSet.getString("car_color");
            car.setId(idFromDB);
            car.setCarName(carName);
            car.setCarModel(carModel);
            car.setCarYear(carYear);
            car.setVinNumber(vinNumber);
            car.setCarColor(carColor);
        }
        connection.close();
        return car;
    }

    @Override
    public List<Car> findAll() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM autos";
        Class.forName("org.postgresql.Driver");
        Connection connection = databaseMain.getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        List<Car> cars = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Car car = new Car(resultSet.getLong("id"), resultSet.getString("car_name"),
                    resultSet.getString("car_model"), resultSet.getString("vin_number"),
                    resultSet.getInt("car_year"), resultSet.getString("car_color"));
            cars.add(car);
        }
        connection.close();
        return cars;
    }

    @Override
    public void deleteById(Long id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM autos WHERE id = ?";
        Class.forName("org.postgresql.Driver");
        Connection connection = databaseMain.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
        connection.close();
    }

    @Override
    public Car findByVin(String vinNumber) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM autos WHERE vin_number = ?";
        Class.forName("org.postgresql.Driver");
        Connection connection = databaseMain.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, vinNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        Car car = new Car();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String carName = resultSet.getString("car_name");
            String carModel = resultSet.getString("car_model");
            int carYear = resultSet.getInt("car_year");
            String vinFromDB = resultSet.getString("vin_number");
            String carColor = resultSet.getString("car_color");
            car.setId(id);
            car.setCarName(carName);
            car.setCarModel(carModel);
            car.setCarYear(carYear);
            car.setVinNumber(vinFromDB);
            car.setCarColor(carColor);
        }
        connection.close();
        return car;
    }
}
