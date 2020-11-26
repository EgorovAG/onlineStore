package com.github.egorovag.onlineStore.model;

import com.github.egorovag.onlineStore.model.enums.Role;

public class AuthUser {
    private long id;
    //    @Pattern(regexp = "[A-Za-zА-Яа-я0-9]{1,50}", message = "логин должен содержать не больше 50 символов и состоять только из букв и цифр")
    private String login;
    //    @Pattern(regexp = "[A-Za-zА-Яа-я0-9]{1,50}", message = "пароль должен содержать не больше 50 символов и состоять только из букв и цифр")
    private String password;
    private Role role;
    private long user_id;

    public AuthUser(long id, String login, String password, Role role, long user_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.user_id = user_id;
    }

    public AuthUser(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public AuthUser(String login, String password, Role role, long user_id) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
