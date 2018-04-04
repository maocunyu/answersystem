package com.yingchuang.dao;

import com.yingchuang.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //查询列表
    List<Users> queryUser();

    //按照id查询
    Users queryUserById(Integer id);

    //按照id修改
    Integer updateUserById(Users users);

    //查询所有userid
    List<Integer> queryAllUserid();

}

