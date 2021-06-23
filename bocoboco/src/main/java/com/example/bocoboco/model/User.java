package com.example.bocoboco.model;

import com.example.bocoboco.entity.UserEntity;

public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private Integer number_grupp;



    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setFirstname(entity.getFirstname());
        model.setLastname(entity.getLastname());
        model.setAge(entity.getAge());
        model.setNumber_grupp(entity.getNumber_grupp());
        return model;


    }

    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber_grupp() {
        return number_grupp;
    }

    public void setNumber_grupp(Integer number_grupp) {
        this.number_grupp = number_grupp;
    }
}
