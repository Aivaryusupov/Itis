package ru.itis.services;

import ru.itis.models.User;

import java.util.List;

public interface SecurityService {

    List<User> findAll();

}
