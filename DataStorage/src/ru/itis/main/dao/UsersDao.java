package ru.itis.main.dao;

import ru.itis.main.models.User;

import java.util.List;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public interface UsersDao extends BaseCrudDao<User>{
    List<User> findAllByAge(int age);
    List<User> findAllByName(String name);
}
