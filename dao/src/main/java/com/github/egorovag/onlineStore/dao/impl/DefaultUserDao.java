package com.github.egorovag.onlineStore.dao.impl;

import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.dao.converter.UserConverter;
import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.dao.repository.UserJpaRepository;
import com.github.egorovag.onlineStore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultUserDao implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultUserDao.class);

    @Autowired
    UserJpaRepository userJpaRepository;

    @Override
    public User readUserByUserIdDao(long user_id) {
        try {
            UserEntity userEntity = userJpaRepository.findById(user_id).orElse(null);
            log.info("User with id: {} read", user_id);
            return UserConverter.fromEntity(userEntity);
        } catch (Exception e) {
            log.error("Fail to read user with id: {}", user_id);
            return null;
        }
    }

    @Override
    public User saveUserDao(User user) {
        try {
            UserEntity userEntity = userJpaRepository.save(UserConverter.toEntity(user));
            log.info("User: {} saved", user);
            return UserConverter.fromEntity(userEntity);
//            log.info("AuthUser: {} and Client : {} saved", authUser, client);
        } catch (Exception e) {
//            log.error("Fail to save AuthUser: {} and Client : {} ", authUser, client, e);
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
}
