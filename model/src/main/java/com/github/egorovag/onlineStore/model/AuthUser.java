package com.github.egorovag.onlineStore.model;

import com.github.egorovag.onlineStore.model.enums.Role;

public class AuthUser {
    private Long id;
    //    @Pattern(regexp = "[A-Za-zА-Яа-я0-9]{1,50}", message = "логин должен содержать не больше 50 символов и состоять только из букв и цифр")
    private String login;
    //    @Pattern(regexp = "[A-Za-zА-Яа-я0-9]{1,50}", message = "пароль должен содержать не больше 50 символов и состоять только из букв и цифр")
    private String password;
    private Role role;
    private Long user_id;

    public AuthUser() {
    }

    public AuthUser(Long id, String login, String password, Role role, Long user_id) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", user_id=" + user_id +
                '}';
    }
}
