package com.college.food.vo;

import com.college.food.common.vo.BaseVo;

public class PostVo extends BaseVo{
    private String topicType;
    private String title;

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
