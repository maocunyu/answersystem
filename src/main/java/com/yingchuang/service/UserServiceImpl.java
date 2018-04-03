package com.yingchuang.service;

import com.yingchuang.dao.UserMapper;
import com.yingchuang.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by msi on 2018/4/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Users queryUserByUserNameAndPassword(String userName, String password) {
        return userMapper.queryUserByUserNameAndPassword(userName,password);
    }

    @Override
    public Integer addUser(Users users) {
        return userMapper.addUser(users);
    }

    @Override
    public Integer updatePasswordByPhone(String phoneNum) {
        return userMapper.updatePasswordByPhone(phoneNum);
    }
}
