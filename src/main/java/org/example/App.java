package org.example;

import org.example.console.ConsoleInterface;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConsoleInterface consoleInterface = new ConsoleInterface();
        consoleInterface.applicationStarter();
    }
}
