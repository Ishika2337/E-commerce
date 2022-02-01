package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/registration")
    public String registrationForm(){
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(HttpServletRequest request){
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        if(username.equals("admin")){
//            customer.setRoles("admin");
            Customer customer = new Customer(username,name,address,password,"admin");
            customerService.createCustomer(customer);
        }
        else {
//            customer.setRoles("user");
            Customer customer = new Customer(username,name,address,password,"user");
            customerService.createCustomer(customer);
        }

        return "showdresses";
    }
    @GetMapping("/showdresses")
    public String showDresses(){
        return "showdresses";
    }
}
