package com.college.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String toindex(){
        return "redirect:/login";
    }
    @RequestMapping("/login")
    public String login(){
        return "/login/login";
    }
}
