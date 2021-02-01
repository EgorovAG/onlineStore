package com.github.egorovag.onlineStore.model.dto;

import com.github.egorovag.onlineStore.model.enums.Role;
import lombok.*;

import java.io.Serializable;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = {"user_id", "login"})
//@ToString(onlyExplicitlyIncluded = true)
public class AuthUserWithUserDto implements Serializable {

    private Long authUser_id;
    private Long user_id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public AuthUserWithUserDto(Long authUser_id, Long user_id, String login, String password, String firstName,
                               String lastName, String email, String phone) {
        this.authUser_id = authUser_id;
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public AuthUserWithUserDto() {
    }

    public Long getAuthUser_id() {
        return authUser_id;
    }

    public void setAuthUser_id(Long authUser_id) {
        this.authUser_id = authUser_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AuthUserWithUserDto{" +
                "authUser_id=" + authUser_id +
                ", user_id=" + user_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

