package com.github.egorovag.onlineStore.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CookieController {
    @RequestMapping(value = "/readCookie", method = RequestMethod.GET)
        public ModelAndView readCookie(@CookieValue(value = "cookieCart", required = false) Cookie cookieCart,
                                          HttpServletRequest request) {

        //you can use also " @CookieValue(value = "cookieName") String cookieName " >cookieName = Cookie.getName();
//        String cookieValue = "cookie with name 'cookieName' is empty";
//        if (cookieCart != null) {
//            cookieCartValue  = "Object: " + cookieName + ";<br/> Name: " + cookieName.getName() + ";<br/> Value: " + cookieName.getValue();
//        }
        return new ModelAndView("/cookie/cookieView", "cookieValueCart",
                Integer.valueOf(cookieCart.toString()));
    }
}
