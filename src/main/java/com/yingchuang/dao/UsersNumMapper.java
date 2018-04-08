package com.yingchuang.dao;

import com.yingchuang.entity.UsersNum;

/**
 * Created by msi on 2018/4/3.
 */
public interface UsersNumMapper {
    //查询admin数量
    Integer queryUsersNum();

    //修改admin  自增
    Integer updateUsersNum();
}
