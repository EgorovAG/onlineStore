package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.User;

public interface UserService {
    User readUserByUserIdService(long user_id);

}
