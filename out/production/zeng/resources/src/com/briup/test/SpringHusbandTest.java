package com.briup.test;

import com.briup.bean.Husband;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class SpringHusbandTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Husband husband = (Husband) ac.getBean("husband");
        System.out.println(husband);
    }
}
