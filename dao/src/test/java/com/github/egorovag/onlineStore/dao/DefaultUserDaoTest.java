package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.dao.config.DaoConfig;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.enums.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
//@Transactional
class DefaultUserDaoTest {

    @Autowired
    AuthUserDao authUserDao;
    @Autowired
    UserDao userDao;

    private AuthUser authUserSave;
    private User userSave;

    @BeforeEach
    void createAuthUserAndUser() {
        User user = new User("user", "user", "email", "55555");
        userSave = userDao.saveUserDao(user);
        AuthUser authUser = new AuthUser("authUser", "authUserPass", Role.Seller, userSave.getId());
        authUserSave = authUserDao.saveAuthUserDao(authUser);
    }


    @Test
    void readUserByUserIdDao() {
        User userNew = userDao.readUserByUserIdDao(userSave.getId());
        Assertions.assertEquals("user", userNew.getFirstName());
    }

//    @Test
//    void readUserByAuthUserDao() {
//        User userRead = userDao.readUserByAuthUserDao(authUserSave);
//        Assertions.assertEquals("user", userRead.getFirstName());
//    }

    @Test
    void testReadUserByAuthUserLoginDao() {
        User userRead = userDao.readUserByAuthUserLoginDao(authUserSave.getLogin());
        Assertions.assertEquals("user", userRead.getFirstName());
    }

    @Test
    void testSaveUserDao() {
        assertEquals("user", userSave.getFirstName());
    }


    @Test
    void testDeleteUserDao() {
        boolean res = userDao.deleteUserDao(userSave.getId());
        Assertions.assertTrue(res);
    }

    @Test
    void testReadListUser() {
        List<User> userList = userDao.readListUser();
        Assertions.assertEquals("user", userList.get(0).getFirstName());
    }

}