package ru.itis.main;

import ru.itis.main.generators.SingletonIdGenerator;
import ru.itis.main.storages.UsersDataStorage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataStorageFactory {
    public static UsersDataStorage getUsersDataStorage() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources\\app.properties"));
            String fileName = properties.getProperty("users.file");

        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
