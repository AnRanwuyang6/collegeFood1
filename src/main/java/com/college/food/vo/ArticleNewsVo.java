package com.college.food.vo;

import com.college.food.common.vo.BaseVo;

public class ArticleNewsVo extends BaseVo {
    //0：新闻 1公告
    private String flag;
    //新闻类型
    private String type;
    //公告类型
    private String annType;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnnType() {
        return annType;
    }

    public void setAnnType(String annType) {
        this.annType = annType;
    }
}
