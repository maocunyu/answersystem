package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Admin;
import com.yingchuang.service.AdminService;
import com.yingchuang.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Max on 4-3-2018-003.
 */
@RequestMapping("admin")
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

//    增加一条
    @ResponseBody
    @RequestMapping(value = "addAdmin",method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    public String addAdmin(Admin admin){
        int n=adminService.addAdmin(admin);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }


//    修改状态byId
    @ResponseBody
    @RequestMapping(value = "updateAdminStatusById",method = RequestMethod.POST,
            produces ="application/json;charset=utf-8")
    public String updateAdminStatusById(Admin admin){
        int n =adminService.updateAdminStatusById(admin);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }

//    修改权限byId
    @ResponseBody
    @RequestMapping(value = "updateAdminStatusById",method = RequestMethod.POST,
            produces ="application/json;charset=utf-8")
    public String updateAdminPowerById(Admin admin){
        int n =adminService.updateAdminPowerById(admin);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }

//    查询所有by激活状态
    @ResponseBody
    @RequestMapping(value = "queryAdminByStatus",method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    public String queryAdminByStatus(Integer status, Integer pageNum, Integer pageSize, Model model){
        PageInfo<Admin> pageInfo=adminService.queryAdminByStatus(0,pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "grade";
    }

}
