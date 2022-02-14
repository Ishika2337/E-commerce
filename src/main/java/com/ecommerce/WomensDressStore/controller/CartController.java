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

import java.security.Principal;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DressesService dressesService;

    @GetMapping("/cart/{id}")
    public String cart(Principal principal, @PathVariable Long id, Model model) {
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        Dresses dresses = dressesService.getById(id);
        Customer customer = customerService.getByUsername(principal.getName());
        model.addAttribute("dress", dresses);
        Cart cart = new Cart();
        cart.setDresses(dresses);
        cart.setCustomer(customer);
        cartService.addToCard(cart);
        return "redirect:/"+dresses.getDressType();
    }
    @GetMapping("/cart")
    public String myCart(Principal principal, Model model){
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        model.addAttribute("myCart",cartService.myCart(principal.getName()));
        return "cart";
    }
    @GetMapping("/myCart/{cartId}")
    public String removeFromCart(@PathVariable Long cartId, Model model, Principal principal){
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        cartService.remove(cartId);
        return "redirect:/cart";
    }
}
