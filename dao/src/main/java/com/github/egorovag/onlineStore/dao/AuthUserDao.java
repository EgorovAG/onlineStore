package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.AuthUser;

public interface AuthUserDao {

    AuthUser getAuthUserByLoginAndByPasswordDao(String login, String password);

    AuthUser getAuthUserByIdDao(Long id);

    AuthUser saveAuthUserDao(AuthUser authUser);

    boolean deleteAuthUserByIdDao(Long id);

    AuthUser getAuthUserByUserIdDao(Long id);

    boolean updateAuthUserDao(AuthUser authUser);

//    AuthUser getAuthUserByLoginDao(String login);
}
