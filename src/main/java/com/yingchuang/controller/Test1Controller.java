package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test1;
import com.yingchuang.service.Test1Service;
import com.yingchuang.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Max on 4-8-2018-008.
 */
@RequestMapping("test1")
@Controller
public class Test1Controller {

    @Resource
    private Test1Service test1Service;

    //查询所有
    @RequestMapping(value = "queryAllTest1",method = RequestMethod.GET)
    public String queryAllTest1(Integer pageNum, Integer pageSize, Model model){
        PageInfo<Test1> pageInfo=test1Service.queryAllTest1(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "listTest1";
    }

    //查询单条
    @ResponseBody
    @RequestMapping(value = "queryTest1ById",method = RequestMethod.GET,
            produces ="application/json;charset=utf-8")
    public String queryTest1ById(Integer id,Model model){
        Test1 queryTest1=test1Service.queryTest1ById(id);
        return JSON.toJSONString(queryTest1);
    }

    //修改状态byId
    @ResponseBody
    @RequestMapping(value = "updateStatusById",method = RequestMethod.POST,
            produces ="application/json;charset=utf-8")
    public String updateStatusById(Test1 test1){
        int n =test1Service.updateStatus(test1);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }
}
