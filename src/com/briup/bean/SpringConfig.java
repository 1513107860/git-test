package com.briup.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.briup.bean")
public class SpringConfig {

    public Teacher1 teacher1(){
        return new Teacher1();
    }
}
