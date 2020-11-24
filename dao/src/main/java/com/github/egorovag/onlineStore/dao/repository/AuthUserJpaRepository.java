package com.github.egorovag.onlineStore.dao.repository;

import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserJpaRepository extends JpaRepository<AuthUser, Long> {
    AuthUserEntity findByLoginAndPassword(String login, String password);
}
