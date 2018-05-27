package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

public class Review {
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 昵称，公司名
     */
    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 审核类别：1：供应商审核，2，采购商审核
     */
    private String type;

    /**
     * 审核状态 0：未审核 1：通过：2驳回
     */
    private String status;

    /**
     * 审核时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 处理人
     */
    private String operater;

    /**
     * 预留字段
     */
    private String str1;

    /**
     * 预留字段
     */
    private String str2;

    /**
     * 预留字段
     */
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取昵称，公司名
     *
     * @return nick_name - 昵称，公司名
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称，公司名
     *
     * @param nickName 昵称，公司名
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 获取审核类别：1：供应商审核，2，采购商审核
     *
     * @return type - 审核类别：1：供应商审核，2，采购商审核
     */
    public String getType() {
        return type;
    }

    /**
     * 设置审核类别：1：供应商审核，2，采购商审核
     *
     * @param type 审核类别：1：供应商审核，2，采购商审核
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取审核状态 0：未审核 1：通过：2驳回
     *
     * @return status - 审核状态 0：未审核 1：通过：2驳回
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置审核状态 0：未审核 1：通过：2驳回
     *
     * @param status 审核状态 0：未审核 1：通过：2驳回
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取审核时间
     *
     * @return create_time - 审核时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置审核时间
     *
     * @param createTime 审核时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取处理人
     *
     * @return operater - 处理人
     */
    public String getOperater() {
        return operater;
    }

    /**
     * 设置处理人
     *
     * @param operater 处理人
     */
    public void setOperater(String operater) {
        this.operater = operater;
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
     * 获取预留字段
     *
     * @return str3 - 预留字段
     */
    public String getStr3() {
        return str3;
    }

    /**
     * 设置预留字段
     *
     * @param str3 预留字段
     */
    public void setStr3(String str3) {
        this.str3 = str3;
    }
}