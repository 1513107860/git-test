package com.briup.bean;

import java.util.Date;

public class Husband {
    private int id;
    private String name;
    private double salary;
    private Date date;

    @Override
    public String toString() {
        return "Husband{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                '}';
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
