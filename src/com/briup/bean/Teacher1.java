package com.briup.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Teacher1 {

    @Value("1")
    private int id;

    @Value("tom")
    private String name;

    @Value("20")
    private int age;

    public Teacher1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Teacher1() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
