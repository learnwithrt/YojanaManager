package com.yojana.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;
 
    @GetMapping({"/","/index.html"})
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }
}
