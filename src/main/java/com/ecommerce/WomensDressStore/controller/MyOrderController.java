package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.entities.MyOrder;
import com.ecommerce.WomensDressStore.service.CustomerService;
import com.ecommerce.WomensDressStore.service.DressesService;
import com.ecommerce.WomensDressStore.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class MyOrderController {
    @Autowired
    private MyOrderService myOrderService;
    @Autowired
    private DressesService dressesService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/buy/{id}")
    public String buy(Principal principal,Model model, @PathVariable Long id){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("dress",dressesService.getById(id));
        return "pay";
    }
    @GetMapping("/pay/{id}")
    public String pay(Principal principal, @PathVariable Long id, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);

        }
        Dresses dresses = dressesService.getById(id);
        Customer customer = customerService.getByUsername(principal.getName());
        model.addAttribute("dress", dresses);
        MyOrder myOrder = new MyOrder();
        myOrder.setDresses(dresses);
        myOrder.setCustomer(customer);
        myOrderService.addToMyOrder(myOrder);
        return "redirect:/myOrder";
    }
    @GetMapping("/myOrder")
    public String myOrder(Principal principal, Model model){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("orders",myOrderService.myOrders(principal.getName()));
        return "myOrder";
    }

    @GetMapping("/order/{id}")
    public String cancelOrder(@PathVariable Long id,Model model, Principal principal){
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        myOrderService.remove(id);
        return "redirect:/myOrder";
    }

}
