package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AuthUserJpaRepository extends JpaRepository<AuthUserEntity, Long> {
    AuthUserEntity findByLoginAndPassword(String login, String password);

    @Query(value = "select au from AuthUserEntity au where au.user_id = :user_id")
    AuthUserEntity findByUser_id(@Param("user_id") Long user_id);

    @Modifying
    @Transactional
    @Query(value = "update AuthUserEntity set login = :login, password = :password where id = :id ")
    void updateAuthUserByAuthUser(@Param("id") Long id,
                                  @Param("login") String login,
                                  @Param("password") String password);
}
