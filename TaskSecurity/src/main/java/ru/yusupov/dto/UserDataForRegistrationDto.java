package ru.yusupov.dto;

public class UserDataForRegistrationDto {
    int id;
    private String login;
    private String password;

    public UserDataForRegistrationDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDataForRegistrationDto(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public UserDataForRegistrationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
