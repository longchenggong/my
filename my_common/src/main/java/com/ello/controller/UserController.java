package com.ello.controller;

import com.ello.entity.User;
import com.ello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/saveUser")
    public User saveUser(User user){
        return user;
    }

    @ResponseBody
    @GetMapping("/getUser")
    public User getUser(){
        User user=new User();
        user.setAge(11);
        user.setName("熊猫");

        return  user;
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public User get( @PathVariable("id") String id){
        return userService.getById(Long.parseLong(id));
    }
    @ResponseBody
    @GetMapping("/id/{id}")
    public User getByName(@PathVariable("id") Long id){
        User byName = userService.getById2(id);
        return byName;
    }
    @ResponseBody
    @GetMapping("/getSql")
    public List getSqlTest(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user ");
        return list;
    }

    @ResponseBody
    @PostMapping("/user")
    public User insertUser(User user){
         userService.insertUser(user);
        return user;
    }

}
