package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

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
    @PostMapping("/registration")
    public String registration(HttpServletRequest request){
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        Customer customer;
        if(username.equals("admin")){
            customer = new Customer(username, name, address, password, "ROLE_ADMIN");
        }
        else {
            customer = new Customer(username, name, address, password, "ROLE_USER");
        }
        customerService.createCustomer(customer);
        return "redirect:/showdresses";
    }

    //LOGIN
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

//    @PostMapping("/login")
//    public String login(HttpServletRequest request, Model model){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        Customer customer;
//        if (customerService.existsByUsername(username)){
//            customer = customerService.getByUsername(username);
//            if (password.equals(customer.getPassword())){
//                model.addAttribute("username",username);
//                return "redirect:/showdresses";
//            } else {
//                model.addAttribute("message", "Wrong Password");
//                return "login";
//            }
//        } else {
//            model.addAttribute("message", "Please enter valid User Name");
//            return "login";
//        }
//    }
    @GetMapping("/success")
    public String login(Principal principal){
        String username = principal.getName();
        if (username.equals("admin")){
            return "redirect:/addDresses";
        }
        return "redirect:/showdresses";
    }

    @GetMapping("/showdresses")
    public String showDresses(){
        return "showdresses";
    }
}
