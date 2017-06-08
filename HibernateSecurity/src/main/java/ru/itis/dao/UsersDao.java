package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

/**
 * 22.05.2017
 * UsersDao
 *
 * @author Aivar Yusupov
 * @version 0.1
 */
public interface UsersDao extends BaseDao<User> {

    User findUserByLogin();
    List<User> findUsersByName();
    List<User> findUsersByAge();

}
