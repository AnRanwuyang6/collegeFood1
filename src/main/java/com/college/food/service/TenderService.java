package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.Tender;
import com.college.food.entity.User;
import com.github.pagehelper.PageInfo;
/**
 * Created by lizongke on 2018/5/9.
 */
public interface TenderService {
    //我的招标文件
    PageInfo<Tender> listAjax(BaseVo vo,String UserId);
    //新建招标
    void  insert(Tender tender, User user);

    //所有招标文件
    PageInfo<Tender> allListAjax(BaseVo vo);
}
