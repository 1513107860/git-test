package com.briup.test;

import com.briup.bean.Teacher1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class SpringTeacherTest {
   public static void main(String[] args) {

      ApplicationContext ac = new AnnotationConfigApplicationContext("com.briup.bean");
      Teacher1 teacher = (Teacher1) ac.getBean("teacher1");

      System.out.println(teacher);
   }
}
