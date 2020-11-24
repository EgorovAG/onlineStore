package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.service.UserService;

public class DefaultUserService implements UserService {
    private UserDao userDao;

    public DefaultUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User readUserByUserIdService(long user_id) {
        return userDao.readUserByUserIdDao(user_id);
    }
}
