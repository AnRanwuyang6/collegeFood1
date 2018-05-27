package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.FoodInformation;
import com.github.pagehelper.PageInfo;

/**
 * Created by lizongke on 2018/5/17.
 */
public interface FoodInformationService {
    //列表
    PageInfo<FoodInformation> listAjax(BaseVo vo,String foodStatus,String typeId);
    //物品添加
    void insert(FoodInformation foodInformation,String userId);
    //
    FoodInformation findOne(String id);
    //
    void update (FoodInformation foodInformation);
    //改变状态
    void alertFlag(String id);

    void delete(String id);
}
