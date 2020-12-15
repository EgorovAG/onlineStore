package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.dto.AuthUserWithUserDto;
import com.github.egorovag.onlineStore.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserService implements UserService {
    private UserDao userDao;
    private AuthUserDao authUserDao;

    public DefaultUserService(UserDao userDao, AuthUserDao authUserDao) {
        this.userDao = userDao;
        this.authUserDao = authUserDao;
    }

    @Override
    @Transactional
    public User readUserByUserIdService(long user_id) {
        return userDao.readUserByUserIdDao(user_id);
    }

    @Override
    @Transactional
    public User saveUserService(User user) {
        return userDao.saveUserDao(user);
    }

    @Override
    public List<AuthUserWithUserDto> readListAuthUserWithUserDto() {
        List<User> users = userDao.readListUser();
        List<AuthUserWithUserDto> listAuthUserWithUserDto = new ArrayList<>();

        for (User user : users) {
            AuthUser authUser = authUserDao.getAuthUserByIdDao(user.getId());
            listAuthUserWithUserDto.add(
                    new AuthUserWithUserDto(
                            user.getId(),
                            authUser.getLogin(),
                            authUser.getPassword(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getEmail(),
                            user.getPhone())
            );
        }
        return listAuthUserWithUserDto;
    }

    @Override
    public boolean deleteUserById(Long user_id) {
        try {
            userDao.deleteUserDao(user_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
