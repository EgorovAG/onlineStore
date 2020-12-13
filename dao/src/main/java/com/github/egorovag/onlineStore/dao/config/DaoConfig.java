package com.github.egorovag.onlineStore.dao.config;

import com.github.egorovag.onlineStore.dao.AuthUserDao;
import com.github.egorovag.onlineStore.dao.OrderOfGoodsDao;
import com.github.egorovag.onlineStore.dao.ProductDao;
import com.github.egorovag.onlineStore.dao.UserDao;
import com.github.egorovag.onlineStore.dao.impl.DefaultAuthUserDao;
import com.github.egorovag.onlineStore.dao.impl.DefaultOrderOfGoodsDao;
import com.github.egorovag.onlineStore.dao.impl.DefaultProductDao;
import com.github.egorovag.onlineStore.dao.impl.DefaultUserDao;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
public class DaoConfig {

    private final SessionFactory sessionFactory;

    public DaoConfig(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Bean
    public AuthUserDao authUserDao() {
        return new DefaultAuthUserDao(userDao());
    }

    @Bean
    public UserDao userDao() {
        return new DefaultUserDao();
    }

    @Bean
    public OrderOfGoodsDao orderOfGoodsDao() {
        return new DefaultOrderOfGoodsDao(userDao(), productDao());
    }

    @Bean
    public ProductDao productDao() {
        return new DefaultProductDao();
    }

}
