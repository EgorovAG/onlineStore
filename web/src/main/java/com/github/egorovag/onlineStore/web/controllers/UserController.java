package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.dto.AuthUserWithUserDto;
import com.github.egorovag.onlineStore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registeredUser")
    public String GetListUsers(Model map) {
        List<AuthUserWithUserDto> listAuthUserWithUserDto = userService.readListAuthUserWithUserDto();
        if (listAuthUserWithUserDto == null || listAuthUserWithUserDto.isEmpty()) {
            map.addAttribute("listAuthUserWithUserDto", null);
        } else {
            map.addAttribute("listAuthUserWithUserDto", listAuthUserWithUserDto);
        }
        return "listOfRegisteredUsers";
    }
    @PostMapping("/delete")
    public String GetListUsers(@RequestParam(value = "user_id") Long user_id, Model map) {
        userService.deleteUserById(user_id);
        List<AuthUserWithUserDto> listAuthUserWithUserDto = userService.readListAuthUserWithUserDto();
        if (listAuthUserWithUserDto == null || listAuthUserWithUserDto.isEmpty()) {
            map.addAttribute("listAuthUserWithUserDto", null);
        } else {
            map.addAttribute("listAuthUserWithUserDto", listAuthUserWithUserDto);
        }
        return "listOfRegisteredUsers";
    }
}
