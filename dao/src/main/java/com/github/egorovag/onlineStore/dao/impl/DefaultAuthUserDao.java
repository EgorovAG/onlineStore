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
    public AuthUser getAuthUserByLoginAndByPasswordDao(String login, String password) {
        try {
            AuthUserEntity authUserEntity = authUserJpaRepository.findByLoginAndPassword(login, password);
            log.info("Get authUser with login {} and  password {}", login, password);
            return AuthUserConverter.fromEntity(authUserEntity);
        } catch (Exception e) {
            log.error("fail to get authUser with login {} and password {}", login, password, e);
            return null;
        }
    }

    @Override
    public AuthUser getAuthUserByIdDao(Long id) {
        try {
            AuthUserEntity authUserEntity = authUserJpaRepository.findById(id).orElse(null);
            log.info("Get authUser with id {} ", id);
            return AuthUserConverter.fromEntity(authUserEntity);
        } catch (Exception e) {
            log.error("fail to get authUser with id {} ", id, e);
            return null;
        }
    }

    @Override
    public AuthUser saveAuthUserDao(AuthUser authUser) {
        try {
            AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
            UserEntity userEntity = UserConverter.toEntity(userDao.readUserByUserIdDao(authUserEntity.getUser_id()));
            authUserEntity.setUserEntity(userEntity);
            AuthUserEntity authUserEntityNew = authUserJpaRepository.save(authUserEntity);
            log.info("AuthUser: {} saved", authUser);
            return AuthUserConverter.fromEntity(authUserEntityNew);
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

    @Override
    public AuthUser getAuthUserByUserIdDao(Long id) {
        try {
            AuthUserEntity authUserEntity = authUserJpaRepository.findByUser_id(id);
            log.info("Get authUser with id {} ", id);
            return AuthUserConverter.fromEntity(authUserEntity);
        } catch (Exception e) {
            log.error("fail to get authUser with id {} ", id, e);
            return null;
        }
    }

    @Override
    public boolean updateAuthUserDao(AuthUser authUser) {
        try {
            AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
            authUserJpaRepository.updateAuthUserByAuthUser(authUserEntity.getId(), authUserEntity.getLogin(),authUserEntity.getPassword());
            log.info("AuthUser with id: {} updated", authUser.getId());
            return true;
        } catch (Exception e) {
            log.error("Fail to update AuthUser with id: {}", authUser.getId(), e);
            return false;
        }
    }
}

