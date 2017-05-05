package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.dao.*;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
//import ru.itis.main.models.User.Builder;

public class Main {

    public static void main(String[] args) {
        AppContext<User> appContext = new AppContext<>();
        UsersDao usersDao = appContext.getComponent(UsersDao.class);
        User myrad = new User.Builder().id(3).login("Vika").password("vikula").name("Виктория").age(22).build();
        System.out.println(usersDao.findAllByName("Виктория"));






    }
}
