package com.yingchuang.service;

import com.yingchuang.entity.UsersNum;

/**
 * Created by msi on 2018/4/5.
 */
public interface UsersNumService {
    //查询admin数量
    UsersNum queryUsersNum();

    //修改admin  自增
    Integer updateUsersNum();
}
