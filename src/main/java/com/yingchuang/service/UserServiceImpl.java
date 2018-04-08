package com.yingchuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingchuang.command.AutoCode;
import com.yingchuang.dao.UserMapper;
import com.yingchuang.dao.UsersNumMapper;
import com.yingchuang.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by msi on 2018/4/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UsersNumMapper usersNumMapper;

    @Override
    public Users queryUserByUserNameAndPassword(String userName, String password) {
        return userMapper.queryUserByUserNameAndPassword(userName,password);
    }

    @Override
    public Integer addUser(Users users) {
        AutoCode autoCode=new AutoCode();
        usersNumMapper.updateUsersNum();
        String userCode=autoCode.autoUsersCode(users,usersNumMapper.queryUsersNum());
        users.setUserCode(userCode);
        return userMapper.addUser(users);
    }

    @Override
    public Integer updatePasswordByPhone(String phoneNum) {
        return userMapper.updatePasswordByPhone(phoneNum);
    }

    @Override
    public PageInfo<Users> queryUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> list = userMapper.queryUser();
        return new PageInfo<>(list);
    }

    @Override
    public Users queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public Integer updateUserById(Users users) {
        return userMapper.updateUserById(users);
    }

    @Override
    public List<Integer> queryAllUserid() {
        return userMapper.queryAllUserid();
    }
}
