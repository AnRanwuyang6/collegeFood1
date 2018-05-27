package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_food_information")
public class FoodInformation {
    @Id
    private String id;

    /**
     * 食材名称
     */
    @Column(name = "food_name")
    private String foodName;

    /**
     * 食材单价
     */
    @Column(name = "food_price")
    private Double foodPrice;

    /**
     * 类别id
     */
    @Column(name = "food_type_id")
    private String foodTypeId;

    /**
     * 类别名称
     */
    @Column(name = "food_type_name")
    private String foodTypeName;

    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 食物图片
     */
    @Column(name = "food_url")
    private String foodUrl;

    /**
     * 描述
     */
    @Column(name = "food_describe")
    private String foodDescribe;

    /**
     * 状态
     */
    private String status;

    /**
     * 大类别
     */
    private String str1;

    private String str2;

    private String str3;

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
     * 获取食材名称
     *
     * @return food_name - 食材名称
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * 设置食材名称
     *
     * @param foodName 食材名称
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * 获取食材单价
     *
     * @return food_price - 食材单价
     */
    public Double getFoodPrice() {
        return foodPrice;
    }

    /**
     * 设置食材单价
     *
     * @param foodPrice 食材单价
     */
    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * 获取类别id
     *
     * @return food_type_id - 类别id
     */
    public String getFoodTypeId() {
        return foodTypeId;
    }

    /**
     * 设置类别id
     *
     * @param foodTypeId 类别id
     */
    public void setFoodTypeId(String foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    /**
     * 获取类别名称
     *
     * @return food_type_name - 类别名称
     */
    public String getFoodTypeName() {
        return foodTypeName;
    }

    /**
     * 设置类别名称
     *
     * @param foodTypeName 类别名称
     */
    public void setFoodTypeName(String foodTypeName) {
        this.foodTypeName = foodTypeName;
    }

    /**
     * @return creat_time
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 获取食物图片
     *
     * @return food_url - 食物图片
     */
    public String getFoodUrl() {
        return foodUrl;
    }

    /**
     * 设置食物图片
     *
     * @param foodUrl 食物图片
     */
    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
    }

    /**
     * 获取描述
     *
     * @return food_describe - 描述
     */
    public String getFoodDescribe() {
        return foodDescribe;
    }

    /**
     * 设置描述
     *
     * @param foodDescribe 描述
     */
    public void setFoodDescribe(String foodDescribe) {
        this.foodDescribe = foodDescribe;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取大类别
     *
     * @return str1 - 大类别
     */
    public String getStr1() {
        return str1;
    }

    /**
     * 设置大类别
     *
     * @param str1 大类别
     */
    public void setStr1(String str1) {
        this.str1 = str1;
    }

    /**
     * @return str2
     */
    public String getStr2() {
        return str2;
    }

    /**
     * @param str2
     */
    public void setStr2(String str2) {
        this.str2 = str2;
    }

    /**
     * @return str3
     */
    public String getStr3() {
        return str3;
    }

    /**
     * @param str3
     */
    public void setStr3(String str3) {
        this.str3 = str3;
    }
}