package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Users;
import com.yingchuang.service.UserService;
import com.yingchuang.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by msi on 2018/4/3.
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public String queryAll(Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Users> pageInfo = userService.queryUser(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "listUser";
    }

    @ResponseBody
    @RequestMapping(value = "queryUserById",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryUserById(Integer id) {
        Users users = userService.queryUserById(id);
        return JSON.toJSONString(users);
    }

    @ResponseBody
    @RequestMapping(value = "updateUserById",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String updateUserById(Users users) {
        Integer rows = userService.updateUserById(users);
        if (rows > 0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }
}
