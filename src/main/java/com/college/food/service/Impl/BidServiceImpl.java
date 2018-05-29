package com.college.food.service.Impl;

import com.college.food.common.utils.SMSUtil;
import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.BidMapper;
import com.college.food.entity.Bid;
import com.college.food.entity.BidExample;
import com.college.food.entity.User;
import com.college.food.model.SMSChangTianYouEntity;
import com.college.food.service.BidService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import groovy.util.logging.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class BidServiceImpl implements BidService{
    @Autowired
    private BidMapper bidMapper;
    @Override
    public PageInfo<Bid> listAjax(BaseVo vo,String tenderId) {
        BidExample example=new BidExample();
        example.createCriteria().andTendersIdEqualTo(tenderId);
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<Bid> bidList=bidMapper.selectByExample(example);
        PageInfo<Bid> pageInfo=new PageInfo<>(bidList);
        return pageInfo;
    }

    @Override
    public void insert(String id, User user) {
        Bid bid=new Bid();
        bid.setId(UUIDUtils.generateUUID());
        bid.setUserId(user.getId());
        bid.setUserName(user.getStr2());
        bid.setCreateTime(new Date());
        bid.setTendersId(id);
        bid.setPhone(user.getPhone());

        bidMapper.insert(bid);
        //发短信通知投标申请成功
        //发短信
        String msg="【河南高校联合采购平台】您已经成功申请投标,请准时到现场进行竞标";
        SMSChangTianYouEntity entity = new SMSChangTianYouEntity();
        entity= SMSUtil.sendSMS(user.getPhone(),msg);

    }
}
