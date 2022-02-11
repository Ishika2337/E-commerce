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
    public String home() {
        return "home";
    }

    //REGISTRATION
    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(HttpServletRequest request) {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        Customer customer;
        if (username.equals("admin")) {
            customer = new Customer(username, name, address, password, "ROLE_ADMIN");
        } else {
            customer = new Customer(username, name, address, password, "ROLE_USER");
        }
        customerService.createCustomer(customer);
        return "redirect:/showdresses";
    }

    //LOGIN
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


    @GetMapping("/success")
    public String login(Principal principal) {
        String username = principal.getName();
        if (username.equals("admin")) {
            return "redirect:/addDresses";
        }
        return "redirect:/showdresses";
    }

    //View Profile
    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("customer", customerService.getByUsername(principal.getName()));
        return "profile";
    }

    //    Update profile
    @GetMapping("/updateProfile")
    public String updateProfileForm(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("customer", customerService.getByUsername(principal.getName()));
        return "updateProfile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(Principal principal, Model model, HttpServletRequest request) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        Customer customer = customerService.getByUsername(principal.getName());
        customer.setName(request.getParameter("name"));
        customer.setAddress(request.getParameter("address"));
        customer.setPassword(request.getParameter("password"));
        customerService.createCustomer(customer);
        return "redirect:/profile";
    }

    @GetMapping("/showdresses")
    public String showDresses(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        return "showdresses";
    }
}
