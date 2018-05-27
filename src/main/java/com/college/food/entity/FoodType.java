package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_food_type")
public class FoodType {
    @Id
    private String id;

    /**
     * 类别名
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 状态（1，上架，0，下架）
     */
    @Column(name = "type_stasus")
    private String typeStasus;

    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预留字段
     */
    private String str1;

    /**
     * 预留字段
     */
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
     * 获取类别名
     *
     * @return type_name - 类别名
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置类别名
     *
     * @param typeName 类别名
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取状态（1，上架，0，下架）
     *
     * @return type_stasus - 状态（1，上架，0，下架）
     */
    public String getTypeStasus() {
        return typeStasus;
    }

    /**
     * 设置状态（1，上架，0，下架）
     *
     * @param typeStasus 状态（1，上架，0，下架）
     */
    public void setTypeStasus(String typeStasus) {
        this.typeStasus = typeStasus;
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
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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