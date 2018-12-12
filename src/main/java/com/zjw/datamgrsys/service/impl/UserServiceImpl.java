package com.zjw.datamgrsys.service.impl;

import com.zjw.datamgrsys.dao.UserMapper;
import com.zjw.datamgrsys.pojo.User;
import com.zjw.datamgrsys.service.UserService;
import com.zjw.datamgrsys.util.MgrResult;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public MgrResult register(User user) {
        if (user==null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getPhone()) ||
                StringUtils.isEmpty(user.getClasses()) || StringUtils.isEmpty(user.getGroupname())){
            return MgrResult.build(500,"数据不全！");
        }
        try{
            if (userMapper.findUserByName(user.getName())!=null){
                return MgrResult.build(500,"用户已存在！");
            }
        }catch (MyBatisSystemException e){
            e.printStackTrace();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        userMapper.insert(user);
        user.setPassword(null);
        return MgrResult.ok(user);
    }

    @Override
    public MgrResult login(User user) {
        if (user==null || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())){
            return MgrResult.build(500,"数据不全！");
        }
        User userDB = userMapper.findUserByName(user.getName());
        try{
            if (userDB==null){
                return MgrResult.build(500,"用户不存在！");
            }
        }catch (MyBatisSystemException e){
            e.printStackTrace();
        }
        if (passwordEncoder.matches(user.getPassword(), userDB.getPassword())){
            userDB.setPassword(null);
            return MgrResult.ok(userDB);
        }
        return MgrResult.build(500,"密码错误！");
    }
}
