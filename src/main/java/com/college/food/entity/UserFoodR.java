package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_food_r")
public class UserFoodR {
    @Id
    private String id;

    /**
     * 供应商id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 食物id
     */
    @Column(name = "food_id")
    private String foodId;

    /**
     * 预留字段
     */
    private String str1;

    /**
     * 预留字段
     */
    private String str2;

    private Date str3;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取供应商id
     *
     * @return user_id - 供应商id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置供应商id
     *
     * @param userId 供应商id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取食物id
     *
     * @return food_id - 食物id
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     * 设置食物id
     *
     * @param foodId 食物id
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * 获取预留字段
     *
     * @return str1 - 预留字段
     */
    public String getStr1() {
        return str1;
    }

    /**
     * 设置预留字段
     *
     * @param str1 预留字段
     */
    public void setStr1(String str1) {
        this.str1 = str1;
    }

    /**
     * 获取预留字段
     *
     * @return str2 - 预留字段
     */
    public String getStr2() {
        return str2;
    }

    /**
     * 设置预留字段
     *
     * @param str2 预留字段
     */
    public void setStr2(String str2) {
        this.str2 = str2;
    }

    /**
     * @return str3
     */
    public Date getStr3() {
        return str3;
    }

    /**
     * @param str3
     */
    public void setStr3(Date str3) {
        this.str3 = str3;
    }
}