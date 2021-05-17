package com.ello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping(value = {"","/"})
    public String login(ModelAndView modelAndView){
        System.out.println("******************************");
        return "index.html";
    }
}
