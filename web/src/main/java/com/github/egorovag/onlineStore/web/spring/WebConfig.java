package com.github.egorovag.onlineStore.web.spring;


import com.github.egorovag.onlineStore.service.AuthUserService;
import com.github.egorovag.onlineStore.service.config.ServiceConfig;
import com.github.egorovag.onlineStore.web.controllers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import java.util.Locale;

@Configuration
@EnableWebMvc
public class WebConfig {

    private ServiceConfig serviceConfig;

    public WebConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Bean
    public Start start() {
        return new Start();
    }

    @Bean
    public GoToPage goToPage() {
        return new GoToPage();
    }

    @Bean
    public CatalogController catalog() {
        return new CatalogController(serviceConfig.productService());
    }

    @Bean
    public CookieController cookieController() {
        return new CookieController();
    }

    @Bean
    public CartController cartController() {
        return new CartController();
    }

    @Bean
    public LoginController loginServlet() {
        return new LoginController(serviceConfig.authUserService(), serviceConfig.userService());
    }

    @Bean
    public LogoutController logoutServlet() {
        return new LogoutController();
    }

    @Bean
    public RegistrationController registrationServlet() {
        return new RegistrationController(serviceConfig.authUserService(), serviceConfig.userService());
    }

    @Bean
    public OrderController orderServlet() {
        return new OrderController(serviceConfig.orderOfGoodsService());
    }

    @Bean
    public UserController userController() {
        return new UserController(serviceConfig.userService(), serviceConfig.authUserService());
    }

    @Bean
    public ProductController productController() {
        return new ProductController(serviceConfig.productService());
    }


//    @Bean
//    public OrderController clientOrderServlet() {
//        return new OrderController(serviceConfig.orderService(), serviceConfig.roomService(),
//                serviceConfig.serviceHotelService());
//    }
//
//    @Bean
//    public PaginationRegisteredUsers paginationRegisteredUsers() {
//        return new PaginationRegisteredUsers(serviceConfig.authUserService());
//    }
//
//    @Bean
//    public RegistrationUsersController registrationUsersController() {
//        return new RegistrationUsersController(serviceConfig.authUserService(), serviceConfig.clientService());
//    }
//
//    @Bean
//    public FileController fileController() {
//        return new FileController();
//    }
//
//    @Bean
//    public ShowCopyPassport showCopyPassport() {
//        return new ShowCopyPassport();
//    }
//
//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(5000000);
//        return new CommonsMultipartResolver();
//    }


    @Bean
    public UrlBasedViewResolver tilesViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
        return tilesConfigurer;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:i18n/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("en"));
        resolver.setCookieName("LocaleCookie");
        resolver.setCookieMaxAge(3600);
        return resolver;
    }
}
