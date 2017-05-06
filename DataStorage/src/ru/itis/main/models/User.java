package ru.itis.main.models;

import java.util.List;


public class User implements Model {
    private int id;
    private String login;
    private String password;
    private String name;
    private int age;
    private List<Auto> autos;

    public static class Builder {
        private int id;
        private String login;
        private String password;
        private String name;
        private int age;
        private List<Auto> autos;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder autos(List<Auto> autos) {
            this.autos = autos;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    private User(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.name = builder.name;
        this.age = builder.age;
        this.autos = builder.autos;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    @Override
    public String toString() {
        return id + " "
                + login + " "
                + password + " "
                + name + " "
                + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof User) {
            User that = (User) obj;
            if(that == this){return true;}
            return this.id == that.id
                    && this.login.equals(that.login)
                    && this.password.equals(that.password)
                    && this.name.equals(that.name)
                    && this.age == that.age;
        }
        return false;
    }
}

