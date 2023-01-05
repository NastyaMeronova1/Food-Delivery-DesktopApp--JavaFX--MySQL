package com.example.food_delivery.Classes;

public class User {
    private String iduser;
    private String login;
    private String password;
    private String name;
    private String role;

    public User(String iduser, String login, String password, String name, String role) {
        this.iduser = iduser;
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(String login, String password, String name, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
