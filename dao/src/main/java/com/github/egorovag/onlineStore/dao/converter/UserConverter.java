package com.github.egorovag.onlineStore.dao.converter;

import com.github.egorovag.onlineStore.dao.entity.UserEntity;
import com.github.egorovag.onlineStore.model.User;

public class UserConverter {
    public static User fromEntity(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPhone());
    }

    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        final UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        return userEntity;
    }
}
