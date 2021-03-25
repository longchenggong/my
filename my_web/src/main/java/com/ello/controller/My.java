package com.ello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/59:20
 */
@Controller
public class My {

    @ResponseBody
    @RequestMapping("/say")
    public String say(){
        return "say:你";
    }
}
