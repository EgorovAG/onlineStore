package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.service.AuthUserService;

public class DefaultAuthUserService implements AuthUserService {
    AuthUserDao authUserDao;

    public DefaultAuthUserService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }
}
