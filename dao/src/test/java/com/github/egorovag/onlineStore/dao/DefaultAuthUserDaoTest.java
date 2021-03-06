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
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
class DefaultAuthUserDaoTest {

    @Autowired
    AuthUserDao authUserDao;
    @Autowired
    UserDao userDao;

    private AuthUser authUserSave;

    @BeforeEach
    void createAuthUserAndUser() {
        User user = new User("user", "user", "email", "55555");
        User userSave = userDao.saveUserDao(user);
        AuthUser authUser = new AuthUser("authUser", "authUserPass", Role.Seller, userSave.getId());
        authUserSave = authUserDao.saveAuthUserDao(authUser);
    }

    @Test
    void testGetAuthUserByLoginAndPasswordDao() {
        AuthUser authUserGet = authUserDao.getAuthUserByLoginAndByPasswordDao(authUserSave.getLogin(), authUserSave.getPassword());
        assertEquals("authUserPass", authUserGet.getPassword());
        assertEquals("authUser", authUserGet.getLogin());
    }

    @Test
    void testGetAuthUserByIdDao() {
        AuthUser authUserGet = authUserDao.getAuthUserByIdDao(authUserSave.getId());
        assertEquals("authUserPass", authUserGet.getPassword());
        assertEquals("authUser", authUserGet.getLogin());
    }

    @Test
    void testSaveAuthUserDao() {
        assertEquals("authUser", authUserSave.getLogin());
    }

    @Test
    void testDeleteAuthUserByIdDao() {
        boolean res = authUserDao.deleteAuthUserByIdDao(authUserSave.getId());
        assertTrue(res);
    }

    @Test
    void testGetAuthUserByUserIdDao() {
        AuthUser authUserByUserIdDaoRes = authUserDao.getAuthUserByUserIdDao(authUserSave.getUser_id());
        assertEquals("authUser", authUserByUserIdDaoRes.getLogin());
    }

    @Test
    void testUpdateAuthUserDao() {
        AuthUser authUserNew = new AuthUser(authUserSave.getId(), "Fedor", "Fedorov",
                authUserSave.getRole(), authUserSave.getUser_id());
        boolean res = authUserDao.updateAuthUserDao(authUserNew);
        assertTrue(res);
    }

//    @Test
//    void testGetAuthUserByLoginDao() {
//        AuthUser authUserByLoginDaoRes = authUserDao.getAuthUserByLoginDao(authUserSave.getLogin());
//        assertEquals("authUser", authUserByLoginDaoRes.getLogin());
//    }

}