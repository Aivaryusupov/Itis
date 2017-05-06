package ru.itis.main;

import ru.itis.main.context.AppContext;
import ru.itis.main.dao.*;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;
import ru.itis.main.services.UsersService;
//import ru.itis.main.models.User.Builder;

public class Main {

    public static void main(String[] args) {
        AppContext<Auto> appContext = new AppContext<>();
        AppContext<User> appContext1 = new AppContext<>();
        UsersDao usersDao = appContext1.getComponent(UsersDao.class);
        AutoDao autoDao = appContext.getComponent(AutoDao.class);
        UsersService usersService = appContext1.getComponent(UsersService.class);
        User user = usersDao.find(2);
        System.out.println(autoDao.findAllAutoByOwner(user));
        System.out.println(usersService.isRegistered(user.getName()));


    }
}
