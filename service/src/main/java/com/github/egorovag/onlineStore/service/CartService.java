package com.github.egorovag.onlineStore.service;

import com.github.egorovag.onlineStore.model.Cart;

public interface CartService {
    int addItemToCart(Cart cart);
    int deleteItemFromCart(Cart cart);
}
