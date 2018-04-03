package com.yingchuang.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by msi on 2018/4/3.
 */
public interface Users {
    Users queryUserByUserNameAndPassword(@Param("userName") String userName,
                                         @Param("password") String password,
                                         @Param("status") Integer status);

    Integer addUser(Users users);
}
