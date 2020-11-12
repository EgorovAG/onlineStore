package com.github.egorovag.onlineStore.dao;


import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.dao.config.DaoConfig;
import com.github.egorovag.onlineStore.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
class ProductDaoTest {
    @Autowired
    ProductDao productDao;

    private Product product;

//    @BeforeEach
//    void saveAuthUserAndClient() {
//        authUser = new AuthUser("alex", "pass", Role.USER);
//        client = new Client(null, "Alex", "Alexandrov", "alex@tut.by", "55555");
//        authUser = authUserDao.saveAuthUserAndClientDao(authUser, client);
//    }

    @Test
    void testGetProductByNameDao() {
        List<Product> products = productDao.getProductByNameDao("alex");
//        Assertions.assertEquals("alex", products.get(0).getName());
        Assertions.assertEquals(5, products.get(0).getPrice());
    }

//    @Test
//    void testReadUserByLoginDao() {
//        AuthUser authUserResult = authUserDao.readUserByLoginDao("alex");
//        Assertions.assertEquals("alex", authUserResult.getLogin());
//        Assertions.assertEquals("pass", authUserResult.getPassword());
//    }
//
//    @Test
//    void testReadListClientDao() {
//        List<AuthUserWithClientDTO> authUserListsRes = authUserDao.readListAuthUserWithClientDTODao();
//        Assertions.assertEquals(1, authUserListsRes.size());
//    }
//
//    @Test
//    void testReadListAuthUserWithClientPaginationDao() {
//        int firstResultPage = 1;
//        int maxResultsPage = 3;
//        List<AuthUserWithClientDTO> authUserListsRes = authUserDao.readListAuthUserWithClientDTOPaginationDao(firstResultPage, maxResultsPage);
//        Assertions.assertEquals(1, authUserListsRes.size());
//    }
//
//    @Test
//    void testCountAuthUserWithClientDao() {
//        int countResult = authUserDao.countAuthUserWithClientDao();
//        Assertions.assertEquals(1, countResult);
//    }
//
//    @Test
//    void testSaveAuthUserAndClientDao() {
//        authUser = authUserDao.saveAuthUserAndClientDao(authUser, client);
//        Assertions.assertNotNull(authUser);
//    }
}