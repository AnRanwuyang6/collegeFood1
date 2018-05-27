package com.college.food.service.Impl;


import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.FoodTypeMapper;
import com.college.food.entity.FoodType;
import com.college.food.entity.FoodTypeExample;
import com.college.food.service.AfterFoodTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/7.
 */
@Service
public class AfterFoodTypeServiceImlp implements AfterFoodTypeService {
    @Autowired
    private FoodTypeMapper foodTypeMapper;
    @Override
    public PageInfo<FoodType> listAjax(BaseVo vo, String status) {
        FoodTypeExample example=new FoodTypeExample();
        if(!status.equals("")){
            example.createCriteria().andTypeStasusEqualTo(status);
        }
        example.setOrderByClause("creat_time desc");
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<FoodType> foodTypes=foodTypeMapper.selectByExample(example);
        PageInfo<FoodType> pageInfo=new PageInfo<>(foodTypes);
        return pageInfo;
    }

    @Override
    public void insert(FoodType foodType) {
        foodType.setId(UUIDUtils.generateUUID());
        foodType.setCreatTime(new Date());
        foodType.setTypeStasus("0");
        foodTypeMapper.insert(foodType);
    }

    @Override
    public void alertFlag(String id) {
        FoodTypeExample example=new FoodTypeExample();
        example.createCriteria().andIdEqualTo(id);
        List<FoodType> foodTypes=foodTypeMapper.selectByExample(example);
        FoodType foodType=new FoodType();
        if(foodTypes.size()>0){
            foodType=foodTypes.get(0);
        }
        if(foodType.getTypeStasus().equals("0")){
            foodType.setTypeStasus("1");
            foodTypeMapper.updateByPrimaryKeySelective(foodType);
        }else{
            foodType.setTypeStasus("0");
            foodTypeMapper.updateByPrimaryKeySelective(foodType);
        }
    }

    @Override
    public void delete(String id) {
        foodTypeMapper.deleteByPrimaryKey(id);
    }
}
