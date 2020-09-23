package com.github.egorovag.onlineStore.dao.converter;


import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
import com.github.egorovag.onlineStore.model.AuthUser;

public class AuthUserConverter {
    public static AuthUser fromEntity(AuthUserEntity authUserEntity) {
        if (authUserEntity == null) {
            return null;
        }
        return new AuthUser(
                authUserEntity.getId(),
                authUserEntity.getLogin(),
                authUserEntity.getPassword(),
                authUserEntity.getRole(),
                authUserEntity.getUser_id());
    }

    public static AuthUserEntity toEntity(AuthUser authUser) {
        if (authUser == null) {
            return null;
        }
        final AuthUserEntity authUserEntity = new AuthUserEntity();
        authUserEntity.setId(authUser.getId());
        authUserEntity.setLogin(authUser.getLogin());
        authUserEntity.setPassword(authUser.getPassword());
        authUserEntity.setRole(authUser.getRole());
        authUserEntity.setUser_id(authUser.getUser_id());
        return authUserEntity;
    }
}
