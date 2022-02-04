package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.Dresses;
import com.ecommerce.WomensDressStore.service.DressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DressesController {
    @Autowired
    private DressesService dressesService;

    @GetMapping("/addDresses")
    public String addDressesForm(){
        return "addDresses";
    }
    @PostMapping("/addDresses")
    public String addDresses(HttpServletRequest request, Model model){
        String dressType = request.getParameter("dressType");
        String brand = request.getParameter("brand");
        String dressUrl = request.getParameter("dressUrl");
        Double cost = Double.parseDouble(request.getParameter("cost"));
        Dresses dresses = new Dresses(brand,dressUrl,cost,dressType);
        dressesService.save(dresses);
        model.addAttribute("msg","added");
        return "addDresses";
    }

    @GetMapping("/{username}/indianWear")
    public String indianWear(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        model.addAttribute("indianWear", dressesService.findByDressType("indianWear"));
        return "indianWear";
    }
    @GetMapping("/{username}/westernWear")
    public String westernWear(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        model.addAttribute("westernWear",dressesService.findByDressType("westernWear"));
        return "westernWear";
    }
}
