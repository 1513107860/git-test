package com.briup.aop.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.briup")
@EnableAspectJAutoProxy
public class AOPConfig {

}
