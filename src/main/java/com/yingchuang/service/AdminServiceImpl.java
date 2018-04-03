package com.yingchuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingchuang.dao.AdminMapper;
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

//    添加一条
    @Override
    public Integer addAdmin(Admin admin) {
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
    public PageInfo<Admin> queryAdminByStatus(Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list=adminMapper.queryAdminByStatus(0);
        return new PageInfo<Admin>(list);
    }


}
