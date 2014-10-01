package ru.korus.tmis.pdm.model;

public class User {

    private String login;

    private String password;

    public User() {
        login = null;
        password = null;
    }

    public User(String username, String password) {
        this.login = username;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
