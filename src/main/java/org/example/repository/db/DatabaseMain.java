package org.example.repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseMain {

    private static final String PREFIX = "jdbc:postgresql:";

    private String url;

    private String login;

    private String password;

    public DatabaseMain(String url, String login, String password) {
        this.url = PREFIX + url;
        this.login = login;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,login,password);
    }
}
