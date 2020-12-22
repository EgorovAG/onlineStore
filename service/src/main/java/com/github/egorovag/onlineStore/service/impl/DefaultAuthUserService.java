package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.service.AuthUserService;
import org.springframework.transaction.annotation.Transactional;

public class DefaultAuthUserService implements AuthUserService {
    private AuthUserDao authUserDao;

    public DefaultAuthUserService(AuthUserDao authUserDao) {
        this.authUserDao = authUserDao;
    }

    @Override
    @Transactional
    public AuthUser getAuthUserService(String login, String password) {
        return authUserDao.getAuthUserByLoginAndByPasswordDao(login, password);
    }

    @Override
    @Transactional
    public boolean checkLogin(String login, String password) {
        return authUserDao.getAuthUserByLoginAndByPasswordDao(login, password) != null;
    }

    ;

    @Override
    @Transactional
    public AuthUser saveAuthUserService(AuthUser authUser) {
        return authUserDao.saveAuthUserDao(authUser);
    }

//    @Override
//    public boolean checkLoginByOnlyLogin(String login) {
//        return authUserDao.getAuthUserByLoginDao(login) != null;
//    }
}



