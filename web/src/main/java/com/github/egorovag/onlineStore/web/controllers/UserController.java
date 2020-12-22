package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.dto.AuthUserWithUserDto;
import com.github.egorovag.onlineStore.service.AuthUserService;
import com.github.egorovag.onlineStore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final AuthUserService authUserService;

    public UserController(UserService userService, AuthUserService authUserService) {
        this.userService = userService;
        this.authUserService = authUserService;
    }

    @GetMapping("/registeredUser")
    public String getListUsers(Model map) {
        List<AuthUserWithUserDto> listAuthUserWithUserDto = userService.readListAuthUserWithUserDto();
        if (listAuthUserWithUserDto == null || listAuthUserWithUserDto.isEmpty()) {
            map.addAttribute("listAuthUserWithUserDto", null);
        } else {
            map.addAttribute("listAuthUserWithUserDto", listAuthUserWithUserDto);
        }
        return "listOfRegisteredUsers";
    }

    @PostMapping("/delete")
    public String getListUsers(@RequestParam(value = "user_id") Long user_id, Model map) {
        userService.deleteUserById(user_id);
        List<AuthUserWithUserDto> listAuthUserWithUserDto = userService.readListAuthUserWithUserDto();
        if (listAuthUserWithUserDto == null || listAuthUserWithUserDto.isEmpty()) {
            map.addAttribute("listAuthUserWithUserDto", null);
        } else {
            map.addAttribute("listAuthUserWithUserDto", listAuthUserWithUserDto);
        }
        return "listOfRegisteredUsers";
    }

    @GetMapping("/personalData")
    public String getAuthUserWithUserById(Model map) {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUserWithUserDto authUserWithUserDto = userService.readAuthUserWithUserDtoByUserIdService(authUser.getUser_id());
        map.addAttribute("authUserWithUserDto", authUserWithUserDto);
        return "userPersonalData";
    }

    @GetMapping("/edit")
    public String editAuthUserAndUserDto(Model map) {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUserWithUserDto authUserWithUserDto = userService.readAuthUserWithUserDtoByUserIdService(authUser.getUser_id());
        map.addAttribute("authUserWithUserDto", authUserWithUserDto);
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateAuthUserWithUser(AuthUserWithUserDto authUserWithUserDto, Model map) {
//        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        if (!authUserWithUserDto.getLogin().equals(authUser.getLogin())) {
//            if (!authUserService.checkLoginByOnlyLogin(authUserWithUserDto.getLogin())) {
//                map.addAttribute("error", "error.registration");
//                AuthUserWithUserDto authUserWithUserDtoDB = userService.readAuthUserWithUserDtoByUserIdService(authUser.getUser_id());
//                map.addAttribute("authUserWithUserDto", authUserWithUserDtoDB);
//                return "editUser";
//            }
//        } else {
            userService.updateAuthUserWithUserService(authUserWithUserDto);
//        }
        return "redirect:/user/personalData";
    }
}
