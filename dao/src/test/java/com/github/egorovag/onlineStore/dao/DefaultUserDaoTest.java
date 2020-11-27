package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.dao.config.DaoConfig;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
class DefaultUserDaoTest {

    @Autowired
    AuthUserDao authUserDao;
    @Autowired
    UserDao userDao;

    @BeforeEach
    void createAuthUserAndUser() {
        User user = new User("user", "user", "email", "55555");
        User userNew = userDao.saveUserDao(user);
        AuthUser authUser = new AuthUser("authUser", "authUserPass", Role.Seller, userNew.getId());
        AuthUser authUserNew = authUserDao.saveAuthUserDao(authUser);
    }

//    @Test
//    void readUserByUserIdDao() {
//    }

//    @Test
//    void readUserByAuthUserDao() {
//    }

    @Test
    void testReadUserByAuthUserLoginDao() {


        }


//    @Test
//    void saveUserDao() {
//    }
//
//    @Test
//    void deleteUserDao() {
//    }
}