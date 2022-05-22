package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);

        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "Host", required = true, defaultValue = "哈哈") String host,
            @CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby));
        System.out.println("host" + host);
        System.out.println("JSESSIONID" + JSESSIONID);

        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }

}
