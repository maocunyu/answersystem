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
import javax.servlet.http.HttpSession;

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
    @RequestMapping(value = "updateAdminPowerById",method = RequestMethod.POST,
            produces ="application/json;charset=utf-8")
    public String updateAdminPowerById(Admin admin){
        int n =adminService.updateAdminPowerById(admin);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }

//    查询所有by激活状态
    @RequestMapping(value = "queryAdminByStatus",method = RequestMethod.GET)
    public String queryAdminByStatus(Integer pageNum, Integer pageSize, Model model){
        PageInfo<Admin> pageInfo=adminService.queryAdminByStatus(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "listAdmin";
    }


    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String adminName, String apassword, HttpSession session, Model model) {
        Admin loginAdmin = adminService.login(adminName, apassword);
        if (loginAdmin != null) {
            if (loginAdmin.getStatus().equals(0)) {
                session.setAttribute("loginAdmin", loginAdmin);
                if (loginAdmin.getPower().equals(0)) {
                    return "superAdmin";
                } else {
                    return "admin";
                }
            }
            model.addAttribute("msg", "该账号已冻结");
            return "adminLogin";
        }
        model.addAttribute("msg", "用户名或密码输入错误！");
        return "adminLogin";
    }

    //首页
    @RequestMapping("toLogin")
    public String toLogin() {
        return "adminLogin";
    }


    //去上传题目页面
    @RequestMapping("toUpload")
    public String toUpload(){
        return "upload";
    }

//    @RequestMapping("uploadTest")
//    public String uploadTest


    //按照id查询
    @ResponseBody
    @RequestMapping(value = "queryAdminById",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryAdminById(Integer id,Model model) {
        Admin queryAdmin = adminService.queryAdminById(id);
        return JSON.toJSONString(queryAdmin);
    }

}
