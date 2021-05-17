package com.ello.service;

import com.ello.entity.User;
import com.ello.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getById(Long id){
        return userMapper.getById(id);
    }

    public User getById2(Long id){
        return userMapper.getById2(id);
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }
}
