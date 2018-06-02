package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_tender")
public class Tender {
    @Id
    private String id;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 发布人
     */
    private String creater;

    /**
     * 发布时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 附件路径
     */
    @Column(name = "file_rul")
    private String fileRul;

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
     * 获取用户Id
     *
     * @return user_id - 用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取发布人
     *
     * @return creater - 发布人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置发布人
     *
     * @param creater 发布人
     */
    public void setCreater(String creater) {
        this.creater = creater;
    }

    /**
     * 获取发布时间
     *
     * @return create_time - 发布时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发布时间
     *
     * @param createTime 发布时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取附件路径
     *
     * @return file_rul - 附件路径
     */
    public String getFileRul() {
        return fileRul;
    }

    /**
     * 设置附件路径
     *
     * @param fileRul 附件路径
     */
    public void setFileRul(String fileRul) {
        this.fileRul = fileRul;
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