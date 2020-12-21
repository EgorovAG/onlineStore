package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByAuthUserEntity(AuthUserEntity authUserEntity);
    UserEntity findUserEntityByAuthUserEntity_Login(String login);

    @Modifying
    @Transactional
    @Query(value = "update UserEntity set firstName = :firstName, lastName = :lastName, email = :email, phone = :phone" +
            " where id = :id ")
    void updateUserByUser(@Param("id") Long id,  @Param("firstName") String firstName, @Param("lastName") String lastName,
                          @Param("email") String email, @Param("phone") String phone);

}
