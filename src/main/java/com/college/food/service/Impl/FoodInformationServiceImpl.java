package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.FoodInformationMapper;
import com.college.food.dao.mybatis.UserFoodRMapper;
import com.college.food.entity.FoodInformation;
import com.college.food.entity.FoodInformationExample;
import com.college.food.entity.UserFoodR;
import com.college.food.service.FoodInformationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/17.
 */
@Service
public class FoodInformationServiceImpl implements FoodInformationService{
    @Autowired
    private FoodInformationMapper foodInformationMapper;
    @Autowired
    private UserFoodRMapper userFoodRMapper;
    @Override
    public PageInfo<FoodInformation> listAjax(BaseVo vo,String foodStatus,String typeId) {
        FoodInformationExample example=new FoodInformationExample();
        if(!foodStatus.equals("")){
            example.createCriteria().andStatusEqualTo(foodStatus).andFoodTypeIdEqualTo(typeId);
        }else{
            example.createCriteria().andFoodTypeIdEqualTo(typeId);
        }
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<FoodInformation> foodInformationList=foodInformationMapper.selectByExample(example);
        PageInfo<FoodInformation> pageInfo=new PageInfo<>(foodInformationList);
        return pageInfo;
    }

    @Override
    public void insert(FoodInformation foodInformation,String id) {
        String foodid=UUIDUtils.generateUUID();
     foodInformation.setId(foodid);
     foodInformation.setCreatTime(new Date());
     foodInformation.setStatus("0");
     foodInformationMapper.insert(foodInformation);
     UserFoodR userFoodR=new UserFoodR();
     userFoodR.setId(UUIDUtils.generateUUID());
     userFoodR.setFoodId(foodid);
     userFoodR.setUserId(id);
     userFoodRMapper.insert(userFoodR);
    }

    @Override
    public FoodInformation findOne(String id) {
        FoodInformationExample  example=new FoodInformationExample();
        example.createCriteria().andIdEqualTo(id);
        FoodInformation foodInformation=foodInformationMapper.selectByExample(example).get(0);
        return foodInformation;
    }

    @Override
    public void update(FoodInformation foodInformation) {
     foodInformationMapper.updateByPrimaryKeySelective(foodInformation);
    }

    @Override
    public void alertFlag(String id) {
     FoodInformationExample  example=new FoodInformationExample();
     example.createCriteria().andIdEqualTo(id);
     FoodInformation foodInformation=foodInformationMapper.selectByExample(example).get(0);
     if(foodInformation.getStatus().equals("1")){
         foodInformation.setStatus("0");
         foodInformationMapper.updateByPrimaryKeySelective(foodInformation);

     }else{
         foodInformation.setStatus("1");
         foodInformationMapper.updateByPrimaryKeySelective(foodInformation);
     }
    }

    @Override
    public void delete(String id) {
        foodInformationMapper.deleteByPrimaryKey(id);
    }
}
