package com.ello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/1920:17
 */
@Controller
public class LoginController {

    @GetMapping(value = {"","/"})
    public String login(ModelAndView modelAndView){
        System.out.println("******************************");
        return "index.html";
    }
}
