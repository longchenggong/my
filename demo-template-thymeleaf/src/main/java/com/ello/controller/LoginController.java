package com.ello.controller;

import com.ello.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/1910:19
 */
@Slf4j
@Controller
public class LoginController {

    @PostMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        mv.addObject(user);
        mv.setViewName("redirect:/");
        request.getSession().setAttribute("user", user);
        return mv;
    }

    @GetMapping("/login")
    public String login(){
        return "index";
    }


    @GetMapping(value = {"","/"})
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        User user = (User) request.getSession().getAttribute("user");
        if (Objects.isNull(user)){
            mv.setViewName("redirect:/user/login");
        }else{
            mv.setViewName("page/index");
            mv.addObject(user);
        }
        return mv;

    }
}
