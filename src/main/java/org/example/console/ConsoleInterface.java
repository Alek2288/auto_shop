package org.example.console;

import org.example.model.Car;
import org.example.service.CarService;
import org.example.service.impl.CarServiceImpl;
import org.example.utils.AutoIncrement;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {

    private final Scanner scanner = new Scanner(System.in);

    private final CarService carService = new CarServiceImpl();

    public void applicationStarter () {
        while (true) {
            userMenu();
            int userChoice = scanner.nextInt();
            handle(userChoice);
        }
    }

    private void userMenu() {
        System.out.println("1. Создать автомобиль");
        System.out.println("2. Найти авто по вин номеру");
        System.out.println("3. Найти авто по id");
        System.out.println("4. Посмотреть все авто");
        System.out.println("5. Удалить авто по id");
        System.out.println("6. Выйти из приложения");
    }
    private void handle(int userChoice) {
        switch (userChoice) {
            case 1 -> {
                scanner.nextLine();
                System.out.println("Введите марку авто");
                String carName = scanner.nextLine();
                System.out.println("Введите модель авто");
                String carModel = scanner.nextLine();
                System.out.println("Введите вин номер авто");
                String vinNumber = scanner.nextLine();
                System.out.println("Введите год выпуска авто");
                int carYear = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите цвет авто");
                String carColor = scanner.nextLine();
                Car car = carService.create(carName, carModel, vinNumber, carYear, carColor);
                System.out.println("Авто успешно создан" + car);
            }
            case 2 -> {
                System.out.println("Введите vin авто, которое хотите найти");
                String vin = scanner.nextLine();
                Car car = carService.getByVin(vin);
                if (car != null) {
                    System.out.println(car);
                } else {
                    System.out.println("Авто с таким vin не существует");
                }
            }
            case 3 -> {
                System.out.println("Введите id авто, которое хотите найти");
                Long id = scanner.nextLong();
                Car car = carService.getById(id);
                if (car != null) {
                    System.out.println(car);
                } else {
                    System.out.println("Авто с таким Id не существует");
                }
            }
            case 4 -> {
                List<Car> cars = carService.getAll();
                if (cars.isEmpty()) {
                    System.out.println("Еще нет ни одного авто");
                } else {
                    System.out.println("Автомобили в хранилище: ");
                    for (Car car : cars) {
                        System.out.println(car);
                    }
                }
            }
            case 5 -> {
                System.out.println("Введите id авто, которое хотите удалить");
                Long id = scanner.nextLong();
                carService.removeById(id);

            }
            case 6 -> System.exit(1);
        }
    }
}
