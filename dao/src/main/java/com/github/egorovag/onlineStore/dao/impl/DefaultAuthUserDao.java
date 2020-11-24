package com.github.egorovag.onlineStore.dao.impl;

        import com.github.egorovag.onlineStore.dao.AuthUserDao;
        import com.github.egorovag.onlineStore.dao.converter.AuthUserConverter;
        import com.github.egorovag.onlineStore.dao.entity.AuthUserEntity;
        import com.github.egorovag.onlineStore.dao.repository.AuthUserJpaRepository;
        import com.github.egorovag.onlineStore.model.AuthUser;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;

public class DefaultAuthUserDao implements AuthUserDao {
    private static final Logger log = LoggerFactory.getLogger(DefaultAuthUserDao.class);

    @Autowired
    AuthUserJpaRepository authUserJpaRepository;

    @Override
    public AuthUser getAuthUserDao(String login, String password) {
        try {
            AuthUserEntity authUserEntity = authUserJpaRepository.findByLoginAndPassword(login, password);
            log.info("Get authUser with login {} password{}", login, password);
            return AuthUserConverter.fromEntity(authUserEntity);
        } catch (Exception e) {
            log.error("fail to get authUser with login {} password{}", login, password);
            return null;
        }
    }
}
