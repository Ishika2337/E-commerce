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

import javax.servlet.http.HttpServletRequest;
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
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        model.addAttribute("dress",dressesService.getById(id));
        model.addAttribute("customer",customerService.getByUsername(principal.getName()));
        return "pay";
    }
    @GetMapping("/pay/{id}")
    public String pay(Principal principal, @PathVariable Long id, Model model, HttpServletRequest request) {
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        Dresses dresses = dressesService.getById(id);
        Customer customer = customerService.getByUsername(principal.getName());
        model.addAttribute("dress", dresses);
        String deliveringAddress = request.getParameter("address");
        MyOrder myOrder = new MyOrder(dresses.getBrand(),dresses.getDressUrl(),dresses.getCost(),dresses.getName(),deliveringAddress);
        myOrder.setCustomer(customer);
        myOrderService.addToMyOrder(myOrder);
        return "redirect:/successfullyBooked";
    }
    @GetMapping("/successfullyBooked")
    public String booked(Principal principal, Model model){
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        Customer customer = customerService.getByUsername(principal.getName());
        model.addAttribute("name", customer.getName());
        return "booked";
    }
    @GetMapping("/myOrder")
    public String myOrder(Principal principal, Model model){
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        model.addAttribute("orders",myOrderService.myOrders(principal.getName()));
        return "myOrder";
    }

    @GetMapping("/order/{id}")
    public String cancelOrder(@PathVariable Long id,Model model, Principal principal){
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        myOrderService.remove(id);
        return "redirect:/myOrder";
    }

}
