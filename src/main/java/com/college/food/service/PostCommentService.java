package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.PostComment;
import com.github.pagehelper.PageInfo;
/**
 * Created by lizongke on 2018/4/9.
 */
public interface PostCommentService {
    //查询
    PageInfo<PostComment> listAjax(BaseVo vo,String key);
    //Co
    PostComment findOne(String id);

    //删除评论
    void delete(String id);
}
