package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_article_news")
public class ArticleNews {
    @Id
    private String id;

    /**
     * 文章标题
     */
    @Column(name = "t_article_title")
    private String tArticleTitle;

    /**
     * 关键字
     */
    @Column(name = "t_article_keywords")
    private String tArticleKeywords;

    /**
     *  0:新闻资讯，1：公告
     */
    @Column(name = "t_article_flag")
    private String tArticleFlag;

    /**
     * 0:市场动态，1：采购常识，2：政策法规，3：联采资讯
     */
    @Column(name = "t_article_type")
    private String tArticleType;

    /**
     * 0:招标公告，1：政策公告，2，通知公告
     */
    @Column(name = "t_announcement_type")
    private String tAnnouncementType;

    /**
     * 发布人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 发布人姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 发布时间
     */
    @Column(name = "crate_time")
    private Date crateTime;

    /**
     * 0:撤回，下线，1，发布上线（默认0）
     */
    private String status;

    /**
     * 是否推荐
     */
    private String str1;

    private String str2;

    /**
     * 内容
     */
    @Column(name = "t_article_contents")
    private String tArticleContents;

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
     * 获取文章标题
     *
     * @return t_article_title - 文章标题
     */
    public String gettArticleTitle() {
        return tArticleTitle;
    }

    /**
     * 设置文章标题
     *
     * @param tArticleTitle 文章标题
     */
    public void settArticleTitle(String tArticleTitle) {
        this.tArticleTitle = tArticleTitle;
    }

    /**
     * 获取关键字
     *
     * @return t_article_keywords - 关键字
     */
    public String gettArticleKeywords() {
        return tArticleKeywords;
    }

    /**
     * 设置关键字
     *
     * @param tArticleKeywords 关键字
     */
    public void settArticleKeywords(String tArticleKeywords) {
        this.tArticleKeywords = tArticleKeywords;
    }

    /**
     * 获取 0:新闻资讯，1：公告
     *
     * @return t_article_flag -  0:新闻资讯，1：公告
     */
    public String gettArticleFlag() {
        return tArticleFlag;
    }

    /**
     * 设置 0:新闻资讯，1：公告
     *
     * @param tArticleFlag  0:新闻资讯，1：公告
     */
    public void settArticleFlag(String tArticleFlag) {
        this.tArticleFlag = tArticleFlag;
    }

    /**
     * 获取0:市场动态，1：采购常识，2：政策法规，3：联采资讯
     *
     * @return t_article_type - 0:市场动态，1：采购常识，2：政策法规，3：联采资讯
     */
    public String gettArticleType() {
        return tArticleType;
    }

    /**
     * 设置0:市场动态，1：采购常识，2：政策法规，3：联采资讯
     *
     * @param tArticleType 0:市场动态，1：采购常识，2：政策法规，3：联采资讯
     */
    public void settArticleType(String tArticleType) {
        this.tArticleType = tArticleType;
    }

    /**
     * 获取0:招标公告，1：政策公告，2，通知公告
     *
     * @return t_announcement_type - 0:招标公告，1：政策公告，2，通知公告
     */
    public String gettAnnouncementType() {
        return tAnnouncementType;
    }

    /**
     * 设置0:招标公告，1：政策公告，2，通知公告
     *
     * @param tAnnouncementType 0:招标公告，1：政策公告，2，通知公告
     */
    public void settAnnouncementType(String tAnnouncementType) {
        this.tAnnouncementType = tAnnouncementType;
    }

    /**
     * 获取发布人id
     *
     * @return user_id - 发布人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置发布人id
     *
     * @param userId 发布人id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取发布人姓名
     *
     * @return user_name - 发布人姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置发布人姓名
     *
     * @param userName 发布人姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取发布时间
     *
     * @return crate_time - 发布时间
     */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
     * 设置发布时间
     *
     * @param crateTime 发布时间
     */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    /**
     * 获取0:撤回，下线，1，发布上线（默认0）
     *
     * @return status - 0:撤回，下线，1，发布上线（默认0）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置0:撤回，下线，1，发布上线（默认0）
     *
     * @param status 0:撤回，下线，1，发布上线（默认0）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取是否推荐
     *
     * @return str1 - 是否推荐
     */
    public String getStr1() {
        return str1;
    }

    /**
     * 设置是否推荐
     *
     * @param str1 是否推荐
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
     * 获取内容
     *
     * @return t_article_contents - 内容
     */
    public String gettArticleContents() {
        return tArticleContents;
    }

    /**
     * 设置内容
     *
     * @param tArticleContents 内容
     */
    public void settArticleContents(String tArticleContents) {
        this.tArticleContents = tArticleContents;
    }
}