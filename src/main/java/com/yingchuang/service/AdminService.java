package com.yingchuang.service;

import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Admin;

/**
 * Created by Max on 4-3-2018-003.
 */

public interface AdminService {

    //    添加一条
    public Integer addAdmin(Admin admin);

    //    修改状态byId
    public Integer updateAdminStatusById(Admin admin);

    //    修改权限byId
    public Integer updateAdminPowerById(Admin admin);

    //    查询所有by激活状态
    public PageInfo<Admin> queryAdminByStatus(Integer pageNum, Integer pageSize);

    //登录
    public Admin login(String auserName, String apassword);

    //按id查询
    Admin queryAdminById(Integer id);

}
