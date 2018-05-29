package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.TenderMapper;
import com.college.food.entity.Tender;
import com.college.food.entity.TenderExample;
import com.college.food.entity.User;
import com.college.food.service.TenderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/9.
 */
@Service
public class TenderServiceImpl  implements TenderService{
    @Autowired
    private TenderMapper tenderMapper;
    @Override
    public PageInfo<Tender> listAjax(BaseVo vo, String UserId) {
        TenderExample example=new TenderExample();
        example.createCriteria().andUserIdEqualTo(UserId);
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<Tender> tenderList=tenderMapper.selectByExample(example);
        PageInfo<Tender> pageInfo=new PageInfo<>(tenderList);
        return pageInfo;
    }

    @Override
    public void insert(Tender tender, User user) {
        tender.setId(UUIDUtils.generateUUID());
        tender.setUserId(user.getId());
        tender.setCreater(user.getStr2());
        tender.setCreateTime(new Date());

        tenderMapper.insert(tender);
    }

    @Override
    public PageInfo<Tender> allListAjax(BaseVo vo) {

        TenderExample example=new TenderExample();
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<Tender> tenderList=tenderMapper.selectByExample(example);
        PageInfo<Tender> pageInfo=new PageInfo<>(tenderList);
        return pageInfo;
    }
}
