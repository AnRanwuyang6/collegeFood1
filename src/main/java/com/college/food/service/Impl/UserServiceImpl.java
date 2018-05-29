package com.college.food.service.Impl;

import com.college.food.common.utils.MD5Utils;
import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.UserMapper;
import com.college.food.entity.User;
import com.college.food.entity.UserExample;
import com.college.food.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo<User> findList(BaseVo vo, String userType) {
        UserExample example=new UserExample();
        if(!userType.equals("")){
           example.createCriteria().andStr3EqualTo(userType);
        }
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<User> userList=userMapper.selectByExample(example);
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public void insert(User user) {
        user.setId(UUIDUtils.generateUUID());
        user.setCreatedate(new Date());
        user.setPassword(MD5Utils.encode(user.getPassword()));
        if(user.getStr3().equals("1")){
            user.setStr1("5");
        }else if(user.getStr3().equals("2")){
            user.setStr1("5");
        }else{
            user.setStr1("2346789a");
        }
        userMapper.insert(user);
    }

    @Override
    public User findOne(String id) {
        UserExample example=new UserExample();
        example.createCriteria().andIdEqualTo(id);
        User user=userMapper.selectByExample(example).get(0);
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
