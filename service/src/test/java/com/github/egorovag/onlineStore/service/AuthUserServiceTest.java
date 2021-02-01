package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.enums.Role;
import com.github.egorovag.onlineStore.service.impl.DefaultAuthUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthUserServiceTest {

    @Mock
    AuthUserDao authUserDao;

    @InjectMocks
    DefaultAuthUserService defaultAuthUserService;

    private User user = new User(5L,"Alex", "Ivanov", "email@mail.com", "+375295555555");
    private AuthUser authUser = new AuthUser(5L,"loginA", "passA", Role.Client, 5L);

    @Test
    void testGetAuthUserService() {
        when(authUserDao.getAuthUserByLoginAndByPasswordDao("loginA", "passA")).thenReturn(authUser);
        AuthUser result = defaultAuthUserService.getAuthUserService("loginA", "passA");
        Assertions.assertEquals(result, authUser);
    }
}
