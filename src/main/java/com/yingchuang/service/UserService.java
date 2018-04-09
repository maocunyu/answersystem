package com.yingchuang.service;

import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Users;

import java.util.List;

/**
 * Created by msi on 2018/4/3.
 */
public interface UserService {
    //根据用户名 密码 状态查询所有
    Users queryUserByUserNameAndPassword(String userName, String password);

    //user的注册添加
    Integer addUser(Users users);

    //用户根据手机号修改密码
    Integer updatePasswordByPhone(String phoneNum);

    //查询列表
    PageInfo<Users> queryUser(Integer pageNum, Integer pageSize);

    //按照id查询
    Users queryUserById(Integer id);

    //按照id修改
    Integer updateUserById(Users users);

    //查询所有userid
    List<Integer> queryAllUserid();

}
