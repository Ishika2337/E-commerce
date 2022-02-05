package com.ecommerce.WomensDressStore.service;

import com.ecommerce.WomensDressStore.entities.Cart;
import com.ecommerce.WomensDressStore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Cart addToCard(Cart cart) {
        return cartRepository.save(cart);
    }
    public List<Cart> myCart(String username){
        return cartRepository.findByCustomerUsername(username);
    }
    public void remove(Long id) {
        cartRepository.deleteById(id);
    }

}
