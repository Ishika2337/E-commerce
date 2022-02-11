package com.ecommerce.WomensDressStore.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}