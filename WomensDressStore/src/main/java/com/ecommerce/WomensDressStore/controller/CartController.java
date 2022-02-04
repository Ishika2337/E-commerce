package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Cart;
import com.ecommerce.WomensDressStore.entities.IndianWear;
import com.ecommerce.WomensDressStore.entities.WesternWear;
import com.ecommerce.WomensDressStore.service.CartService;
import com.ecommerce.WomensDressStore.service.CustomerService;
import com.ecommerce.WomensDressStore.service.IndianWearService;
import com.ecommerce.WomensDressStore.service.WesternWearService;
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
    private IndianWearService indianWearService;
    @Autowired
    private WesternWearService westernWearService;

    @GetMapping("/{username}/cart/{id}")
    public String cart(@PathVariable String username, @PathVariable Long id, Model model) {
        model.addAttribute("username", username);
        if (indianWearService.existsByIndianWearId(id)) {
            IndianWear indianWear = indianWearService.getById(id);
            model.addAttribute("dress", indianWear);
            Cart cart = new Cart(indianWear.getBrand(),indianWear.getDressUrl(),indianWear.getCost());
            cartService.addToCard(cart);
        }
        if (westernWearService.existsByWesternWearId(id)) {
            WesternWear westernWear = westernWearService.getById(id);
            model.addAttribute("dress", westernWear);
            Cart cart = new Cart(westernWear.getBrand(), westernWear.getDressUrl(), westernWear.getCost());
            cartService.addToCard(cart);
        }
        return "cart";
    }

}


//if (indianWearService.existsByIndianWearId(id)){
//        model.addAttribute("dress",indianWearService.getById(id));
//        }
//        if (westernWearService.existsByWesternWearId(id)){
//        model.addAttribute("dress",westernWearService.getById(id));
//        }