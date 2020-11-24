package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.service.AuthUserService;

public class DefaultAuthUserService implements AuthUserService {
    private AuthUserDao authUserDao;

    public DefaultAuthUserService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }

    @Override
    public AuthUser getAuthUserService(String login, String password) {
        return authUserDao.getAuthUserDao(login, password);
    }
}


