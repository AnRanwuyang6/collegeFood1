package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User {
    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 0：男，1：女
     */
    private String sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 头像
     */
    private String image;

    /**
     * 创建时间
     */
    private Date createdate;

    private String email;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取0：男，1：女
     *
     * @return sex - 0：男，1：女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置0：男，1：女
     *
     * @param sex 0：男，1：女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取头像
     *
     * @return image - 头像
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置头像
     *
     * @param image 头像
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取创建时间
     *
     * @return createdate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return str1
     */
    public String getStr1() {
        return str1;
    }

    /**
     * @param str1
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