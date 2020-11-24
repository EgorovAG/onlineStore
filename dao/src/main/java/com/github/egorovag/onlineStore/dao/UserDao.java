package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.model.User;

public interface UserDao {
    User readUserByUserIdDao(long user_id);
}
