package com.github.egorovag.onlineStore.dao;

import com.github.egorovag.onlineStore.dao.config.DaoConfig;
import com.github.egorovag.onlineStore.model.AuthUser;
import com.github.egorovag.onlineStore.model.OrderOfGoods;
import com.github.egorovag.onlineStore.model.Product;
import com.github.egorovag.onlineStore.model.User;
import com.github.egorovag.onlineStore.model.enums.OrderStatus;
import com.github.egorovag.onlineStore.model.enums.ProductName;
import com.github.egorovag.onlineStore.model.enums.Role;
import net.sf.ehcache.search.expression.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
class DefaultOrderOfGoodsDaoTest {
    @Autowired
    OrderOfGoodsDao orderOfGoodsDao;
    @Autowired
    UserDao userDao;
    @Autowired
    AuthUserDao authUserDao;
    @Autowired
    ProductDao productDao;
    private Product productNew;
    private OrderOfGoods orderOfGoodsNew;
    private AuthUser authUserNew;
    private User userNew;

    @BeforeEach
    void createOrderOfGoods() {
        User user = new User("user", "user", "email", "55555");
        userNew = userDao.saveUserDao(user);
        AuthUser authUser = new AuthUser("authUser", "authUserPass", Role.Seller, userNew.getId());
        authUserNew = authUserDao.saveAuthUserDao(authUser);
        Product product = new Product(ProductName.Faucets, "Gloria", "color white", 50, 10);
        productNew = productDao.saveProductDao(product);
        OrderOfGoods orderOfGoods = new OrderOfGoods(userNew.getId(), productNew.getId(),
                LocalDate.of(2020, 12, 5), 50, 1, OrderStatus.InWork,
                "Minsk,Skoriny str.5", LocalDate.of(2020, 12, 10));
        orderOfGoodsNew = orderOfGoodsDao.saveOrderOfGoodsDao(orderOfGoods);
    }

    @Test
    void testGetListOrderOfGoodsDao() {
        List<OrderOfGoods> listOrderOfGoodsNew = orderOfGoodsDao.getListOrderOfGoodsDao();
        Assertions.assertEquals(productNew.getId(), listOrderOfGoodsNew.get(0).getProduct_id());
    }

    @Test
    void testDeleteOrderOfGoodsDao() {
        boolean res = orderOfGoodsDao.deleteOrderOfGoodsDao(orderOfGoodsNew.getId());
        Assertions.assertTrue(res);
    }

    @Test
    void testSaveOrderOfGoodsDao() {
        Assertions.assertEquals(userNew.getId(), orderOfGoodsNew.getUser_id());
    }

    @Test
    void testUpdateOrderOfGoodsDao() {
        OrderOfGoods orderOfGoods = new OrderOfGoods(userNew.getId(), productNew.getId(),
                LocalDate.of(2030, 12, 5), 10, 5, OrderStatus.InWork,
                "Minsk,Skoriny str.5", LocalDate.of(2030, 12, 10));
        OrderOfGoods orderOfGoodsNewUpdate = orderOfGoodsDao.updateOrderOfGoodsDao(orderOfGoods);
        Assertions.assertEquals(orderOfGoods.getPriceOrder(), orderOfGoodsNewUpdate.getPriceOrder());
    }

    @Test
    void testGetOrderOfGoodsDao() {
        orderOfGoodsDao.getOrderOfGoodsDao(orderOfGoodsNew.getId());
        Assertions.assertEquals(userNew.getId(), orderOfGoodsNew.getUser_id());
    }

    @Test
    void testUpdateOrderCompletedForOrderOfGoodsByIdDao(){
        boolean res = orderOfGoodsDao.updateOrderCompletedForOrderOfGoodsByIdDao(orderOfGoodsNew.getId());
        Assertions.assertTrue(res);
    }





}