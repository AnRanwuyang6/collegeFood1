package com.college.food.entity;

import java.util.ArrayList;

public class MyUtil {
    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "MyUtil{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }
}
