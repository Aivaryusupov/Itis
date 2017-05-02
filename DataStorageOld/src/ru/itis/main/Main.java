package ru.itis.main;

import ru.itis.main.storages.DataStorageFactory;
import ru.itis.main.storages.UsersDataStorage;
import ru.itis.main.storages.AutoDataStorage;

public class Main {

    public static void main(String[] args) {
        UsersDataStorage storage = DataStorageFactory.getUsersDataStorage();
        AutoDataStorage autosStorage = DataStorageFactory.getAutoDataStorage();
    }
}
