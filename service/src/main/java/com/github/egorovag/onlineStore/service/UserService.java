package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.dto.AuthUserWithUserDto;

import java.util.List;

public interface UserService {
    
    User readUserByUserIdService(long user_id);

    User saveUserService(User user);

    List<AuthUserWithUserDto> readListAuthUserWithUserDto();


    void deleteUserById(Long user_id);

    AuthUserWithUserDto readAuthUserWithUserDtoByUserIdService(Long user_id);

    void updateAuthUserWithUserService(AuthUserWithUserDto authUserWithUserDto);
}
