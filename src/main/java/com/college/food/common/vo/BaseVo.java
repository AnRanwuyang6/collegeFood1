package com.college.food.common.vo;

import java.io.Serializable;

/**
 * Created by kong on 2018/1/2.
 *
 * @author kong
 */
public class BaseVo implements Serializable {
    /**
     * 页数
     */
    private Integer page = 1;

    /**
     *
     * 每页条数
     */
    private Integer size = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
