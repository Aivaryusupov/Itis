package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.config.AppConfig;
import ru.itis.models.User;
import ru.itis.services.SecurityService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SecurityService securityService = context.getBean(SecurityService.class);
        List<User> films = securityService.findAll();
        System.out.println(films);
    }

}
