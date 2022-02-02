package com.ecommerce.WomensDressStore.controller;

import com.ecommerce.WomensDressStore.entities.IndianWear;
import com.ecommerce.WomensDressStore.entities.WesternWear;
import com.ecommerce.WomensDressStore.service.IndianWearService;
import com.ecommerce.WomensDressStore.service.WesternWearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DressesController {
    @Autowired
    private IndianWearService indianWearService;
    @Autowired
    private WesternWearService westernWearService;

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
        if (dressType.equals("indianWear")){
            IndianWear indianWear = new IndianWear(brand,dressUrl,cost);
            indianWearService.addIndianWear(indianWear);
        }
        if (dressType.equals("westernWear")){
            WesternWear westernWear = new WesternWear(brand,dressUrl,cost);
            westernWearService.addWesternWear(westernWear);
        }
        model.addAttribute("msg","added");
        return "addDresses";
    }
    @GetMapping("/{username}/indianWear")
    public String indianWear(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        model.addAttribute("indianWear", indianWearService.indianWearList());
        return "indianWear";
    }
    @GetMapping("/{username}/westernWear")
    public String westernWear(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        model.addAttribute("westernWear",westernWearService.westernWearList());
        return "westernWear";
    }
}
