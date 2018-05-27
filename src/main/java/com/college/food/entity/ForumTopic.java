package com.college.food.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_forum_topic")
public class ForumTopic {
    @Id
    private String id;

    /**
     * 论坛板块主题名
     */
    @Column(name = "topic_name")
    private String topicName;

    /**
     * 论坛板块主题封面
     */
    @Column(name = "topic_img")
    private String topicImg;

    /**
     * 状态（0，禁用，1，启用）
     */
    @Column(name = "topic_status")
    private String topicStatus;

    /**
     * 帖子数量
     */
    @Column(name = "article_count")
    private Integer articleCount;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * 描述
     */
    @Column(name = "topic_describe")
    private String topicDescribe;

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
     * 获取论坛板块主题名
     *
     * @return topic_name - 论坛板块主题名
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置论坛板块主题名
     *
     * @param topicName 论坛板块主题名
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * 获取论坛板块主题封面
     *
     * @return topic_img - 论坛板块主题封面
     */
    public String getTopicImg() {
        return topicImg;
    }

    /**
     * 设置论坛板块主题封面
     *
     * @param topicImg 论坛板块主题封面
     */
    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    /**
     * 获取状态（0，禁用，1，启用）
     *
     * @return topic_status - 状态（0，禁用，1，启用）
     */
    public String getTopicStatus() {
        return topicStatus;
    }

    /**
     * 设置状态（0，禁用，1，启用）
     *
     * @param topicStatus 状态（0，禁用，1，启用）
     */
    public void setTopicStatus(String topicStatus) {
        this.topicStatus = topicStatus;
    }

    /**
     * 获取帖子数量
     *
     * @return article_count - 帖子数量
     */
    public Integer getArticleCount() {
        return articleCount;
    }

    /**
     * 设置帖子数量
     *
     * @param articleCount 帖子数量
     */
    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    /**
     * 获取创建人
     *
     * @return creater - 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置创建人
     *
     * @param creater 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater;
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
     * 获取描述
     *
     * @return topic_describe - 描述
     */
    public String getTopicDescribe() {
        return topicDescribe;
    }

    /**
     * 设置描述
     *
     * @param topicDescribe 描述
     */
    public void setTopicDescribe(String topicDescribe) {
        this.topicDescribe = topicDescribe;
    }
}