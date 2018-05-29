package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.ForumPost;
import com.college.food.entity.User;
import com.college.food.vo.PostVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by lizongke on 2018/5/27.
 */
public interface ForumPostService {
    PageInfo<ForumPost> listAjax(PostVo vo);
    //查找单个帖子
    ForumPost findOne(String id);
    //改变上下线
     void alertFlag(String id);
     //置为精华帖
    void toGood(String id);
    //置为置顶帖
    void toTop(String id);
    //删除帖子
    void delete(String id);
    //发帖
    void insert(ForumPost forumPost,User user);


}
