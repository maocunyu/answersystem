package com.yingchuang.dao;

import com.yingchuang.entity.Users;
import org.apache.ibatis.annotations.Param;

/**
 * Created by msi on 2018/4/3.
 */
public interface UserMapper {
    //根据用户名 密码 状态查询所有
    Users queryUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    //user的注册添加
    Integer addUser(Users users);

    //用户根据手机号修改密码
    Integer updatePasswordByPhone(String phoneNum);
}
