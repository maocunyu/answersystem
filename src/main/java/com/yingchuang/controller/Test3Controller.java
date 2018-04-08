package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test3;
import com.yingchuang.service.Test3Service;
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
@RequestMapping("test3")
@Controller
public class Test3Controller {

    @Resource
    private Test3Service test3Service;

    //查询所有
    @RequestMapping(value = "queryAllTest3",method = RequestMethod.GET)
    public String queryAllTest3(Integer pageNum, Integer pageSize, Model model){
        PageInfo<Test3> pageInfo=test3Service.queryAllTest3(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "listTest3";
    }

    //查询单条
    @ResponseBody
    @RequestMapping(value = "queryTest3ById",method = RequestMethod.GET,
            produces ="application/json;charset=utf-8")
    public String queryTest3ById(Integer id,Model model){
        Test3 queryTest3=test3Service.queryTest3ById(id);
        return JSON.toJSONString(queryTest3);
    }

    //修改状态byId
    @ResponseBody
    @RequestMapping(value = "updateStatusById",method = RequestMethod.POST,
            produces ="application/json;charset=utf-8")
    public String updateStatusById(Test3 test3){
        int n =test3Service.updateStatus(test3);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }
}
