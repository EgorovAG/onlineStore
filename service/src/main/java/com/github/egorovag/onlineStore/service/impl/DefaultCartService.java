package com.github.egorovag.onlineStore.service.impl;

import com.github.egorovag.onlineStore.model.Cart;
import com.github.egorovag.onlineStore.service.CartService;

public class DefaultCartService implements CartService {

    @Override
    public int addItemToCart(Cart cart) {
        return cart.getQuantity()+1;
    }

    @Override
    public int deleteItemFromCart(Cart cart) {
        return cart.getQuantity()-1;
    }
}
