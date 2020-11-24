package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.AuthUser;

public interface AuthUserDao {

    AuthUser getAuthUserDao(String login, String password);
}
