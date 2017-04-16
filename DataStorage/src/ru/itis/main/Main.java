package ru.itis.main;

import ru.itis.main.generators.IdGenerator;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.storages.AutoDataStorage;
import ru.itis.main.storages.UsersDataStorage;

public class Main {

    public static void main(String[] args) {
        IdGenerator idGenerator = new IdGenerator("id.txt");
        UsersDataStorage usersDataStorage = new UsersDataStorage("users.txt", idGenerator);
        AutoDataStorage autoDataStorage = new AutoDataStorage("autos.txt", idGenerator);
        Auto car = new Auto ("ferrari", "red", 10);
        User ayaz = new User("ayazTheBest",
                "qwerty008", "Ayaz", 25);
        int userId = usersDataStorage.save(ayaz);
        System.out.println(userId);
        int autoId = autoDataStorage.save(car);
        System.out.println(autoId);
        //System.out.println(usersDataStorage.find(6));
        //System.out.println(usersDataStorage.findAll());
        //User forUpdate = new User("maksim", "qwerty10", "Maksim", 99);
        //forUpdate.setId(13);
        //usersDataStorage.update(forUpdate);
    }
}
