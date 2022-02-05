package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    //HOME
    @GetMapping("/")
    public String home(){
        return "home";
    }

    //REGISTRATION
    @GetMapping("/registration")
    public String registrationForm(){
        return "registration";
    }
    @PostMapping("/login")
    public String registration(HttpServletRequest request){
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        Customer customer;
        if(username.equals("admin")){
            customer = new Customer(username, name, address, password, "admin");
        }
        else {
            customer = new Customer(username, name, address, password, "user");
        }
        customerService.createCustomer(customer);
        return "login";
    }

    //LOGIN
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/showdresses")
    public String login(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer customer;
        if (customerService.existsByUsername(username)){
            customer = customerService.getByUsername(username);
            if (password.equals(customer.getPassword())){
                model.addAttribute("username",username);
            }else {
                model.addAttribute("message", "Wrong Password");
                return "login";
            }
        } else {
            model.addAttribute("message", "Please enter valid User Name");
            return "login";
        }
        return "showdresses";
    }

    @GetMapping("/showdresses")
    public String showDresses(Model model){
        return "showdresses";
    }
}
