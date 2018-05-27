package com.college.food.service;


import com.college.food.common.vo.BaseVo;
import com.college.food.entity.FoodType;
import com.github.pagehelper.PageInfo;

/**
 * Created by lizongke on 2018/5/7.
 */
public interface AfterFoodTypeService {
    PageInfo<FoodType> listAjax(BaseVo vo, String status);
    void insert(FoodType foodType);

    void alertFlag(String id);

    void delete(String id);
}
