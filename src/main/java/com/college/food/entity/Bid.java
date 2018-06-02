package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_bid")
public class Bid {
    @Id
    private String id;

    /**
     * 招标id
     */
    @Column(name = "tenders_id")
    private String tendersId;

    /**
     * 投标人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 投标人名字
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 投标人电话
     */
    private String phone;

    /**
     * 投标时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取招标id
     *
     * @return tenders_id - 招标id
     */
    public String getTendersId() {
        return tendersId;
    }

    /**
     * 设置招标id
     *
     * @param tendersId 招标id
     */
    public void setTendersId(String tendersId) {
        this.tendersId = tendersId;
    }

    /**
     * 获取投标人id
     *
     * @return user_id - 投标人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置投标人id
     *
     * @param userId 投标人id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取投标人名字
     *
     * @return user_name - 投标人名字
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置投标人名字
     *
     * @param userName 投标人名字
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取投标人电话
     *
     * @return phone - 投标人电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置投标人电话
     *
     * @param phone 投标人电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取投标时间
     *
     * @return create_time - 投标时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置投标时间
     *
     * @param createTime 投标时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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