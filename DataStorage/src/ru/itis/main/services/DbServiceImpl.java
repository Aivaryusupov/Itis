package ru.itis.main.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public abstract class DbServiceImpl {

    private static Connection connection = null;

    public static Connection connect() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("resources\\app.properties"));
            String url = properties.getProperty("sql.jdbc.url");
            String user = properties.getProperty("sql.db.user.name");
            String password = properties.getProperty("sql.db.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (SQLException e) {
            System.err.println("SQL Exception");
        }
        try {
            Class.forName("org.postgresql.Driver");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
