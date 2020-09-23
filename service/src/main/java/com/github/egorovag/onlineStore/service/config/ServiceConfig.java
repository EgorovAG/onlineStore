package com.github.egorovag.onlineStore.service.config;


import com.github.egorovag.onlineStore.dao.config.DaoConfig;
import com.github.egorovag.onlineStore.service.AuthUserService;
import com.github.egorovag.onlineStore.service.OrderOfGoodsService;
import com.github.egorovag.onlineStore.service.ProductService;
import com.github.egorovag.onlineStore.service.UserService;
import com.github.egorovag.onlineStore.service.impl.DefaultAuthUserService;
import com.github.egorovag.onlineStore.service.impl.DefaultOrderOfGoodsService;
import com.github.egorovag.onlineStore.service.impl.DefaultProductService;
import com.github.egorovag.onlineStore.service.impl.DefaultUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    private DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Bean
    public AuthUserService authUserService() {
        return new DefaultAuthUserService(daoConfig.authUserDao());
    }

    @Bean
    public UserService userService() {
        return new DefaultUserService(daoConfig.userDao());
    }

    @Bean
    public OrderOfGoodsService orderOfGoodsService() {
        return new DefaultOrderOfGoodsService(daoConfig.orderOfGoodsDao());
    }

    @Bean
    public ProductService productService() {
        return new DefaultProductService(daoConfig.productDao());
    }
}

