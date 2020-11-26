package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByAuthUserEntity(AuthUserEntity authUserEntity);
    UserEntity findUserEntityByAuthUserEntity_Login(String login);

}
