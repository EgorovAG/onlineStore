package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthUserJpaRepository extends JpaRepository<AuthUserEntity, Long> {
    AuthUserEntity findByLoginAndPassword(String login, String password);

    @Query(value = "select au from AuthUserEntity au where au.user_id = :user_id")
    AuthUserEntity findByUser_id(@Param("user_id") Long user_id);
}
