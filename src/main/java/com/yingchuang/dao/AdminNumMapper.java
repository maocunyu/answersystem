package com.yingchuang.dao;

import com.yingchuang.entity.AdminNum;

/**
 * Created by msi on 2018/4/3.
 */
public interface AdminNumMapper {

    //查询admin数量
    AdminNum queryAdminNum();

    //修改admin  自增
    Integer updateAdminNum();
}
