package com.github.egorovag.onlineStore.model.dto;

import com.github.egorovag.onlineStore.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"user_id"})
@ToString(onlyExplicitlyIncluded = true)
public class AuthUserWithUserDto {
    private long user_id;
    private String login;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


}

