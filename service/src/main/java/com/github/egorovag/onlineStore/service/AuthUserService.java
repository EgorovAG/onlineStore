package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;

public interface AuthUserService {

    AuthUser getAuthUserService(String login, String password);


    boolean checkLogin(String login, String password);

    AuthUser saveAuthUserService(AuthUser authUser);
}
