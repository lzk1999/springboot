package com.huang.controller;

import com.huang.mapper.UserMapper;
import com.huang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/queryUserList",produces = "application/json;charset=utf-8")
    public List<User> queryUserList(){
        List<User> userList=userMapper.queryUserList();
        System.out.println("userList:"+userList);
        return userList;
    }
}
