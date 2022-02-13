package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Cart;
import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.entities.MyOrder;
import com.ecommerce.WomensDressStore.service.CartService;
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
        Dresses dresses = new Dresses(brand, dressUrl, cost, dressType,name);
        dressesService.save(dresses);
        model.addAttribute("msg", "added");
        return "addDresses";
    }

    @GetMapping("/allDresses")
    public String allDresses(Model model) {
        model.addAttribute("allDresses", dressesService.allDresses());
        return "allDresses";
    }

    @GetMapping("/update/{id}")
    public String updateDressForm(@PathVariable Long id, Model model) {
        model.addAttribute("dress", dressesService.getById(id));
        return "updateDress";
    }

    @PostMapping("/{id}/update")
    public String updateDress(@PathVariable Long id, HttpServletRequest request){
        Dresses dresses = dressesService.getById(id);
        dresses.setDressUrl(request.getParameter("dressUrl"));
        dresses.setBrand(request.getParameter("brand"));
        dresses.setCost(Double.parseDouble(request.getParameter("cost")));
        dresses.setDressType(request.getParameter("dressType"));
        dresses.setName(request.getParameter("name"));
        dressesService.save(dresses);
        return "redirect:/allDresses";
    }

    @GetMapping("/{id}/delete")
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
            model.addAttribute("username", username);
        }
        model.addAttribute("indianWear", dressesService.findByDressType("indianWear"));
        return "indianWear";
    }

    @GetMapping("/westernWear")
    public String westernWear(Principal principal,Model model) {
        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
        }
        model.addAttribute("westernWear", dressesService.findByDressType("westernWear"));
        return "westernWear";
    }
}
