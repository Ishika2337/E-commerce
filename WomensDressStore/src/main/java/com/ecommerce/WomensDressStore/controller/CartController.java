package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Cart;
import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
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
        Customer customer = customerService.getByUsername(username);
        model.addAttribute("dress", dresses);
        Cart cart = new Cart();
        cart.setDresses(dresses);
        cart.setCustomer(customer);
        cartService.addToCard(cart);
        return "redirect:/"+username+"/"+dresses.getDressType();
    }
    @GetMapping("/{username}/cart")
    public String myCart(@PathVariable String username, Model model){
        model.addAttribute("myCart",cartService.myCart(username));
        return "cart";
    }
    @GetMapping("/cart/{cartId}/{username}")
    public String removeFromCart(@PathVariable Long cartId,@PathVariable String username,Model model){
        model.addAttribute("username",username);
        cartService.remove(cartId);
        return "redirect:/"+username+"/cart";
    }
}
