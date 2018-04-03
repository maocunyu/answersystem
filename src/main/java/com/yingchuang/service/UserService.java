package com.yingchuang.service;

import com.yingchuang.entity.Users;

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
}
