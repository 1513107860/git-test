package com.briup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLOutput;

@Controller
public class UserController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("根据id查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String password){
        System.out.println("添加用户信息："+username+","+password);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("添加用户信息："+username+","+password);
        return "success";
    }
}
