package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;

public interface UserDao {
    User readUserByUserIdDao(long id);
    User readUserByAuthUserDao(AuthUser authUser);
    User readUserByAuthUserLoginDao(String login);
    User saveUserDao(User user);
    boolean deleteUserDao(Long id);
}
