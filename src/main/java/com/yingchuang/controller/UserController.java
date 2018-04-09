package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.command.MD5.MD5;
import com.yingchuang.entity.Users;
import com.yingchuang.service.UserService;
import com.yingchuang.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by msi on 2018/4/3.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Resource
    private UserService userService;

    //首页
    @RequestMapping("toLoginUser")
    public String toLogin() {
        return "userLogin";
    }

//    用户登录
    @RequestMapping(value = "loginUser",method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session, Model model) {
        MD5 md5=new MD5();
        String pwd=md5.getMd5(password,15);
        Users loginUser = userService.queryUserByUserNameAndPassword(username,pwd);
        if (loginUser != null) {
            if (loginUser.getStatus().equals(0)) {
                session.setAttribute("loginUser", loginUser);
                return "user";
            } else {
                model.addAttribute("msg", "该账号已冻结");
                return "userLogin";
            }
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "userLogin";
    }

//    查询所有
    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public String queryAll(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Users> pageInfo = userService.queryUser(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "listUser";
    }

//    查询单条byId
    @ResponseBody
    @RequestMapping(value = "queryUserById",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryUserById(Integer id) {
        Users users = userService.queryUserById(id);
        return JSON.toJSONString(users);
    }

//    修改byId
    @ResponseBody
    @RequestMapping(value = "updateUserById",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String updateUserById(Users users) {
        Integer rows = userService.updateUserById(users);
        if (rows > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }

    //用户注册
    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String addUser(Users users) {
        int rows = userService.addUser(users);
        if (rows > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }
}
