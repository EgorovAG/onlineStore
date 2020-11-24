package com.github.egorovag.onlineStore.web.controllers;

import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.service.AuthUserService;
import com.github.egorovag.onlineStore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final AuthUserService authUserService;
    private final UserService userService;
    private AuthUser authUser;

    public LoginController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }

}

    @GetMapping("/login")
    public String doGet(HttpSession session) {
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        if (authUser == null) {
            return "login";
        }
        return "personalArea!!!!!!!!!!!!!!!!!!!!!!!!!";
    }

    @PostMapping("/login")
    public String checkAuthUser(@RequestParam(value = "login") String login,
                                @RequestParam(value = "password") String password, Model model, HttpSession session) {
        authUser = authUserService.getAuthUserService(login, password);
        if (authUser == null) {
            model.addAttribute("error", "error.login");
            return "entry";
        } else {
            if (authUser.getLogin().equals("Seller")) {

                session.setAttribute("authUser", authUser);
                log.info("user {} logged", authUser.getLogin());
                Authentication auth = new UsernamePasswordAuthenticationToken(authUser, null, getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                return "personalArea";
            } else {
                session.setAttribute("authUser", authUser);
                User user = userService.readUserByUserIdService(authUser.getUser_id());
                if (user != null) {
                    session.setAttribute("user", user);
                }
                log.info("user {} logged", authUser.getLogin());
                Authentication auth = new UsernamePasswordAuthenticationToken(authUser, null, getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                return "personalArea";

                return "personalArea";
            }
        }
    }

    private List<GrantedAuthority> getAuthorities() {
        if (authUser.getLogin().equals("Seller")) {
            return Arrays.asList((GrantedAuthority) () -> "ROLE_SELLER");
        } else {
            return Arrays.asList((GrantedAuthority) () -> "ROLE_CLIENT");
        }
    }
}
