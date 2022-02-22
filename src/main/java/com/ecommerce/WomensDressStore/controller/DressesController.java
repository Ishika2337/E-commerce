package com.ecommerce.WomensDressStore.controller;
import com.ecommerce.WomensDressStore.entities.Customer;
import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.service.CartService;
import com.ecommerce.WomensDressStore.service.CustomerService;
import com.ecommerce.WomensDressStore.service.DressesService;
import com.ecommerce.WomensDressStore.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;
@Transactional
@Controller
public class DressesController {
    @Autowired
    private DressesService dressesService;
    @Autowired
    private CartService cartService;
    @Autowired
    private MyOrderService myOrderService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/addDresses")
    public String addDressesForm() {
        return "addDresses";
    }

    @PostMapping("/addDresses")
    public String addDresses(HttpServletRequest request, Model model) {
        String dressType = request.getParameter("dressType");
        String brand = request.getParameter("brand");
        String dressUrl = request.getParameter("dressUrl");
        Double cost = Double.parseDouble(request.getParameter("cost"));
        String name = request.getParameter("name");
        if (cost<=0){
            model.addAttribute("msg", "cost must be positive");
        } else {
            Dresses dresses = new Dresses(brand, dressUrl, cost, dressType,name);
            dressesService.save(dresses);
            model.addAttribute("msg", "added");
        }

        return "addDresses";
    }

    @GetMapping("/allDresses")
    public String allDresses(Model model) {
        model.addAttribute("allDresses", dressesService.allDresses());
        return "allDresses";
    }

    @GetMapping("/dress/update/{id}")
    public String updateDressForm(@PathVariable Long id, Model model) {
        model.addAttribute("dress", dressesService.getById(id));
        return "updateDress";
    }

    @PostMapping("/dress/update/{id}")
    public String updateDress(@PathVariable Long id, HttpServletRequest request, Model model){
        Dresses dresses = dressesService.getById(id);
        Double cost = Double.parseDouble(request.getParameter("cost"));

        if (cost<=0){
            model.addAttribute("msg", "Cost must be positive");
            return "redirect:/dress/update/{id}";
        }
        else {
            dresses.setDressUrl(request.getParameter("dressUrl"));
            dresses.setBrand(request.getParameter("brand"));
            dresses.setCost(cost);
            dresses.setDressType(request.getParameter("dressType"));
            dresses.setName(request.getParameter("name"));
            dressesService.save(dresses);
            return "redirect:/allDresses";
        }


    }

    @GetMapping("/dress/delete/{id}")
    public String deleteDress(@PathVariable Long id){
        if (cartService.existsByDressesId(id)){
            cartService.removeByDressesId(id);
        }
        dressesService.remove(id);
        return "redirect:/allDresses";
    }

    @GetMapping("/indianWear")
    public String indianWear(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        model.addAttribute("indianWear", dressesService.findByDressType("indianWear"));
        return "indianWear";
    }

    @GetMapping("/westernWear")
    public String westernWear(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            Customer customer = customerService.getByUsername(username);
            model.addAttribute("username", customer.getName());
        }
        model.addAttribute("westernWear", dressesService.findByDressType("westernWear"));
        return "westernWear";
    }
}
