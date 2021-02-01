package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.dto.AuthUserWithUserDto;
import com.github.egorovag.onlineStore.model.enums.Role;
import com.github.egorovag.onlineStore.service.impl.DefaultUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserDao userDao;
    @Mock
    AuthUserDao authUserDao;

    @InjectMocks
    DefaultUserService defaultUserService;

    private User user = new User(5L, "Alex", "Ivanov", "email@mail.com", "+375295555555");
    private AuthUser authUser = new AuthUser(5L, "loginA", "passA", Role.Client, 5L);
    private AuthUserWithUserDto authUserWithUserDto = new AuthUserWithUserDto(authUser.getId(),user.getId(),
            authUser.getLogin(),authUser.getPassword(),user.getFirstName(),user.getLastName(), user.getEmail(),user.getPhone());
    private List<User> userList = new ArrayList<>();
    private List<AuthUserWithUserDto> authUserWithUserDtos = new ArrayList<>();

    @Test
    void testReadListAuthUserWithUserDto() {
        userList.add(user);
        authUserWithUserDtos.add(authUserWithUserDto);
        when(userDao.readListUser()).thenReturn(userList);
        when(authUserDao.getAuthUserByIdDao(5L)).thenReturn(authUser);
        when(defaultUserService.readListAuthUserWithUserDto()).thenReturn(authUserWithUserDtos);
        List<AuthUserWithUserDto> result = defaultUserService.readListAuthUserWithUserDto();
        Assertions.assertEquals(result, authUserWithUserDtos);
    }
}