package com.atguigu.mvc.bean;

public class User {
   private Integer id;
   private String username;
   private String pssword;
   private Integer age;
   private String sex;
   private String email;

    public User() {
    }

    public User(Integer id, String username, String pssword, Integer age, String sex, String email) {
        this.id = id;
        this.username = username;
        this.pssword = pssword;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pssword='" + pssword + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPssword() {
        return pssword;
    }

    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
