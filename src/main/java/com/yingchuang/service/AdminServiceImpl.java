package com.yingchuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingchuang.command.AutoCode;
import com.yingchuang.dao.AdminMapper;
import com.yingchuang.dao.AdminNumMapper;
import com.yingchuang.entity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Max on 4-3-2018-003.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private AdminNumMapper adminNumMapper;

//    添加一条
    @Override
    public Integer addAdmin(Admin admin) {
        AutoCode autoCode=new AutoCode();
        adminNumMapper.updateAdminNum();
        String adminCode=autoCode.autoAdminCode(admin,adminNumMapper.queryAdminNum());
        admin.setAdminCode(adminCode);
        return adminMapper.addAdmin(admin);
    }

//    修改状态byId
    @Override
    public Integer updateAdminStatusById(Admin admin) {
        return adminMapper.updateAdminStatusById(admin);
    }

//    修改权限byId
    @Override
    public Integer updateAdminPowerById(Admin admin) {
        return adminMapper.updateAdminPowerById(admin);
    }

//    查询所有by激活状态
    @Override
    public PageInfo<Admin> queryAdminByStatus(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list=adminMapper.queryAdminByStatus();
        return new PageInfo<Admin>(list);
    }

    @Override
    public Admin login(String auserName, String apassword) {
        return adminMapper.login(auserName, apassword);
    }

    @Override
    public Admin queryAdminById(Integer id) {
        return adminMapper.queryAdminById(id);
    }


}
