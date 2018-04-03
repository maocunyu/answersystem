package com.yingchuang.service;

import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Max on 4-3-2018-003.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {

    @Resource
    private AdminService adminService;

//    添加一条
    @Test
    public void addAdmin() throws Exception {
        Admin admin=new Admin(0,0,0,"admin1","1234","1234567",new Date());

        int n=adminService.addAdmin(admin);
        if (n>0) {
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }

//    修改状态byId
    @Test
    public void updateAdminStatusById() throws Exception {
        Admin admin=new Admin();
        admin.setStatus(0);
        admin.setId(1);
        int n=adminService.updateAdminStatusById(admin);
        if (n>0) {
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }

//    修改权限byId
    @Test
    public void updateAdminPowerById() throws Exception {
        Admin admin=new Admin();
        admin.setPower(2);
        admin.setId(1);
        int n=adminService.updateAdminPowerById(admin);
        if (n>0) {
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }

//    查询所有by激活状态
    @Test
    public void queryAdminByStatus() throws Exception {
        PageInfo<Admin> pageInfo = adminService.queryAdminByStatus(0,1,3);
        List<Admin> list = pageInfo.getList();
        if (list!=null) {
            for (Admin admin : list) {
                System.out.println(admin);
            }
        }
    }

}