package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import org.springframework.stereotype.Service;

public interface IUserService {
    public UserInfo login(UserInfo userInfo) throws MyException;

}
