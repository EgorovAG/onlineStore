package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.dao.converter.AuthUserConverter;
import com.github.egorovag.onlineStore.dao.converter.UserConverter;
import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.dao.repository.UserJpaRepository;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultUserDao implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);

    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public User readUserByUserIdDao(long id) {
        try {
            UserEntity userEntity = userJpaRepository.findById(id).orElse(null);
            log.info("User with id: {} read", id);
            return UserConverter.fromEntity(userEntity);
        } catch (Exception e) {
            log.error("Fail to read user with id: {}", id, e);
            return null;
        }
    }

//        @Override
//        public User readUserByAuthUserDao(AuthUser authUser) {
//            try {
//                UserEntity userEntity = userJpaRepository.findUserEntityByAuthUserEntity(AuthUserConverter.toEntity(authUser));
//                log.info("User with authUserLogin: {} read", authUser.getLogin());
//                return UserConverter.fromEntity(userEntity);
//            } catch (Exception e) {
//                log.error("Fail to read user with authUserLogin: {}", authUser.getLogin(), e);
//                return null;
//            }
//    }

    @Override
    public User readUserByAuthUserLoginDao(String login) {
        try {
            UserEntity userEntity = userJpaRepository.findUserEntityByAuthUserEntity_Login(login);
            log.info("User with login: {} read", login);
            return UserConverter.fromEntity(userEntity);
        } catch (Exception e) {
            log.error("Fail to read user with login: {}", login, e);
            return null;
        }
    }

    @Override
    public User saveUserDao(User user) {
        try {
            UserEntity userEntity = userJpaRepository.save(UserConverter.toEntity(user));
            log.info("User: {} saved", user);
            return UserConverter.fromEntity(userEntity);
        } catch (HibernateException e) {
            log.error("Fail to save user: {} ", user, e);
            return null;
        }
    }

    @Override
    public boolean deleteUserDao(Long id) {
            try {
                userJpaRepository.deleteById(id);
                log.info("User with : {} id deleted", id);
                return true;
            } catch (Exception e) {
                log.error("Fail to delete User with : {} id ", id, e);
                return false;
            }
        }

    @Override
    public User updateUserDao(User user) {
        return null;
    }
}
