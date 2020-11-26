package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.dao.converter.AuthUserConverter;
import com.github.egorovag.onlineStore.dao.converter.UserConverter;
import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.dao.repository.AuthUserJpaRepository;
import com.github.egorovag.onlineStore.dao.repository.UserJpaRepository;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultAuthUserDao implements AuthUserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);
    private final UserDao userDao;

    @Autowired
    AuthUserJpaRepository authUserJpaRepository;

    public DefaultAuthUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public AuthUser getAuthUserDao(String login, String password) {
        try {
            AuthUserEntity authUserEntity = authUserJpaRepository.findByLoginAndPassword(login, password);
            log.info("Get authUser with login {} password{}", login, password);
            return AuthUserConverter.fromEntity(authUserEntity);
        } catch (Exception e) {
            log.error("fail to get authUser with login {} password{}", login, password);
            return null;
        }
    }

    @Override
    public AuthUser saveAuthUserDao(AuthUser authUser) {
        try {
            AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
            UserEntity userEntity = UserConverter.toEntity(userDao.readUser(authUserEntity.getLogin()));
            authUserEntity.setUserEntity(userEntity);
            authUserJpaRepository.save(authUserEntity);
            log.info("AuthUser: {} saved", authUser);
            return AuthUserConverter.fromEntity(authUserEntity);
//            log.info("AuthUser: {} and Client : {} saved", authUser, client);
        } catch (Exception e) {
//            log.error("Fail to save AuthUser: {} and Client : {} ", authUser, client, e);
            log.error("Fail to save AuthUser: {} ", authUser, e);
            return null;
        }
    }

    @Override
    public boolean deleteAuthUserByIdDao(Long id) {
        try {
            authUserJpaRepository.deleteById(id);
            log.info("AuthUser with : {} id deleted", id);
            return true;
        } catch (Exception e) {
            log.error("Fail to delete AuthUser with : {} id ", id, e);
            return false;
        }
    }
}
