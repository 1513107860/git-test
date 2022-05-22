package com.briup.test;

import com.briup.bean.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SuppressWarnings("resource")
public class SpringRoleTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Role.xml");

        Role role = (Role) ac.getBean("role");
        System.out.println(role);
    }
}
