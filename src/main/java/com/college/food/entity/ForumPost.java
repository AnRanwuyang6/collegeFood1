package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_forum_post")
public class ForumPost {
    @Id
    private String id;

    /**
     * 帖子标题
     */
    @Column(name = "post_title")
    private String postTitle;

    /**
     * 创建时间
     */
    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 发帖人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 主题板块id
     */
    @Column(name = "type_id")
    private String typeId;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 回复数
     */
    @Column(name = "reply_count")
    private Integer replyCount;

    /**
     * 置顶：1
     */
    private String str1;

    /**
     * 0：普通帖 1：精华帖 2热门贴
     */
    private String str2;

    private String str3;

    /**
     * 帖子内容
     */
    @Column(name = "post_content")
    private String postContent;

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
     * 获取帖子标题
     *
     * @return post_title - 帖子标题
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * 设置帖子标题
     *
     * @param postTitle 帖子标题
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    /**
     * 获取创建时间
     *
     * @return creat_time - 创建时间
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置创建时间
     *
     * @param creatTime 创建时间
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * 获取发帖人id
     *
     * @return user_id - 发帖人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置发帖人id
     *
     * @param userId 发帖人id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取主题板块id
     *
     * @return type_id - 主题板块id
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置主题板块id
     *
     * @param typeId 主题板块id
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取最后更新时间
     *
     * @return last_update_time - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 获取回复数
     *
     * @return reply_count - 回复数
     */
    public Integer getReplyCount() {
        return replyCount;
    }

    /**
     * 设置回复数
     *
     * @param replyCount 回复数
     */
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    /**
     * 获取置顶：1
     *
     * @return str1 - 置顶：1
     */
    public String getStr1() {
        return str1;
    }

    /**
     * 设置置顶：1
     *
     * @param str1 置顶：1
     */
    public void setStr1(String str1) {
        this.str1 = str1;
    }

    /**
     * 获取0：普通帖 1：精华帖 2热门贴
     *
     * @return str2 - 0：普通帖 1：精华帖 2热门贴
     */
    public String getStr2() {
        return str2;
    }

    /**
     * 设置0：普通帖 1：精华帖 2热门贴
     *
     * @param str2 0：普通帖 1：精华帖 2热门贴
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

    /**
     * 获取帖子内容
     *
     * @return post_content - 帖子内容
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * 设置帖子内容
     *
     * @param postContent 帖子内容
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}