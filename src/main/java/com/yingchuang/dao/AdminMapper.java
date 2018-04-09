package com.yingchuang.dao;

import com.yingchuang.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Max on 4-3-2018-003.
 */
public interface AdminMapper {

//    添加一条
    public Integer addAdmin(Admin admin);

//    修改状态byId
    public Integer updateAdminStatusById(Admin admin);

//    修改权限byId
    public Integer updateAdminPowerById(Admin admin);

//    查询所有by激活状态
    public List<Admin> queryAdminByStatus();

    //登录
    public Admin login(@Param("adminName") String adminName, @Param("apassword") String apassword);

    //按id查询
    Admin queryAdminById(Integer id);
}
