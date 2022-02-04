package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Cart;
import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DressesService dressesService;

    @GetMapping("/{username}/cart/{id}")
    public String cart(@PathVariable String username, @PathVariable Long id, Model model) {
        model.addAttribute("username", username);
        Dresses dresses = dressesService.getById(id);
        model.addAttribute("dress", dresses);
        Cart cart = new Cart(dresses.getBrand(), dresses.getDressUrl(), dresses.getCost());
        cartService.addToCard(cart);
        return "cart";
    }
}
