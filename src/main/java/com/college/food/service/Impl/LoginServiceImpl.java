package com.college.food.service.Impl;

import com.college.food.common.utils.MD5Utils;
import com.college.food.dao.mybatis.UserMapper;
import com.college.food.entity.User;
import com.college.food.entity.UserExample;
import com.college.food.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lizongke─=≡Σ(((つ•̀ω•́)つ) on 2018/5/18.
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findOne(String Username, String password) {
        User user=new User();
        UserExample userExample=new UserExample();
        String md5pwd=MD5Utils.encode(password);

        userExample.createCriteria().andUsernameEqualTo(Username).andPasswordEqualTo(md5pwd.toUpperCase());
        List<User> users=userMapper.selectByExample(userExample);
        if(users.size()>0){
            user=users.get(0);
        }

        return user;
    }
}
