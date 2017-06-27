package ru.yusupov.service;

import ru.yusupov.dto.UserDataForRegistrationDto;
import ru.yusupov.models.User;

import java.util.List;

public interface UsersService {
    UserDataForRegistrationDto registerUser(UserDataForRegistrationDto user);
    String login(String password, String login);
    List<User> getUsers();
}
