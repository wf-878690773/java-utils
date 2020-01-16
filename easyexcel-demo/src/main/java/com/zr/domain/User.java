package com.zr.domain;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;


public class User {

    @ExcelProperty(value = "id",index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名",index = 1)
    private String name;
    @ExcelProperty(value = "密码",index = 2)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
