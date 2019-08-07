package com.neuedu.impl;

import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo login(UserInfo userInfo) throws MyException {

        //非空校验

        if (userInfo == null){
            throw  new MyException("参数不能为空");
        }

        if (userInfo.getUsername()==null||userInfo.getUsername().equals("")){
            throw new MyException("用户名不能为空");

        }
        if (userInfo.getPassword()==null||userInfo.getPassword().equals("")){
            throw new MyException("密码不能为空");

        }


        //判断用户名是否存在
       int username_result= userInfoMapper.exsitsUsername(userInfo.getUsername());
        if(username_result==0) {
            throw new MyException("用户名不存在");
        }
             //登录
        UserInfo userInfo_result=userInfoMapper.findByUsernameAndPassword(userInfo);
                if (userInfo_result==null){
                    throw new MyException("密码错误");
                }
        //判断权限
        if(userInfo_result.getRole()!=0){//不是管理员
            throw new MyException("没有权限访问");
        }

        return userInfo_result;
    }


}
