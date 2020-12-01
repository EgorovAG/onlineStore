package com.github.egorovag.onlineStore.web.controllers;

import ch.qos.logback.core.net.server.Client;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.enums.Role;
import com.github.egorovag.onlineStore.service.AuthUserService;
import com.github.egorovag.onlineStore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class RegistrationController {


    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final AuthUserService authUserService;
    private final UserService userService;

    public RegistrationController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String toRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String doPost(Model map, HttpSession session, AuthUser authUser, User user) {
        System.out.println(authUser);
        System.out.println(user);
        if (!authUserService.checkLogin(authUser.getLogin(), authUser.getPassword())) {
            User userNew = userService.saveUserService(user);
            authUser.setRole(Role.Client);
            authUser.setUser_id(userNew.getId());
            authUserService.saveAuthUserService(authUser);
            return "login";
        } else {
            map.addAttribute("error", "error.registration");
            return "registration";
        }
    }
}

