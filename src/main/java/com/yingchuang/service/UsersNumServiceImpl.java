package com.yingchuang.service;

import com.yingchuang.dao.UsersNumMapper;
import com.yingchuang.entity.UsersNum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by msi on 2018/4/5.
 */
@Service
public class UsersNumServiceImpl implements UsersNumService {
    @Resource
    private UsersNumMapper usersNumMapper;

    @Override
    public UsersNum queryUsersNum() {
        return usersNumMapper.queryUsersNum();
    }

    @Override
    public Integer updateUsersNum() {
        return usersNumMapper.updateUsersNum();
    }
}
