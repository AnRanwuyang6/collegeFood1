package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_post_comment")
public class PostComment {
    @Id
    private String id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户头像
     */
    @Column(name = "user_img")
    private String userImg;

    /**
     * 用户昵称
     */
    @Column(name = "user_nickname")
    private String userNickname;

    /**
     * 帖子id
     */
    @Column(name = "post_id")
    private String postId;

    /**
     * 帖子标题
     */
    @Column(name = "post_title")
    private String postTitle;

    /**
     * 评论内容
     */
    private String contents;

    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private Date commentTime;

    /**
     * 支持数量
     */
    @Column(name = "su_count")
    private Integer suCount;

    private String str;

    private String str2;

    private Integer str3;

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
     * 获取用户头像
     *
     * @return user_img - 用户头像
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * 设置用户头像
     *
     * @param userImg 用户头像
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    /**
     * 获取用户昵称
     *
     * @return user_nickname - 用户昵称
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 设置用户昵称
     *
     * @param userNickname 用户昵称
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * 获取帖子id
     *
     * @return post_id - 帖子id
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 设置帖子id
     *
     * @param postId 帖子id
     */
    public void setPostId(String postId) {
        this.postId = postId;
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
     * 获取评论内容
     *
     * @return contents - 评论内容
     */
    public String getContents() {
        return contents;
    }

    /**
     * 设置评论内容
     *
     * @param contents 评论内容
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * 获取评论时间
     *
     * @return comment_time - 评论时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评论时间
     *
     * @param commentTime 评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取支持数量
     *
     * @return su_count - 支持数量
     */
    public Integer getSuCount() {
        return suCount;
    }

    /**
     * 设置支持数量
     *
     * @param suCount 支持数量
     */
    public void setSuCount(Integer suCount) {
        this.suCount = suCount;
    }

    /**
     * @return str
     */
    public String getStr() {
        return str;
    }

    /**
     * @param str
     */
    public void setStr(String str) {
        this.str = str;
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
    public Integer getStr3() {
        return str3;
    }

    /**
     * @param str3
     */
    public void setStr3(Integer str3) {
        this.str3 = str3;
    }
}