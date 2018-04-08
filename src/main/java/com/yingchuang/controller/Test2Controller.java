package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test2;
import com.yingchuang.service.Test2Service;
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
@RequestMapping("test2")
@Controller
public class Test2Controller {

    @Resource
    private Test2Service test2Service;

    //查询所有
    @RequestMapping(value = "queryAllTest2",method = RequestMethod.GET)
    public String queryAllTest2(Integer pageNum, Integer pageSize, Model model){
        PageInfo<Test2> pageInfo=test2Service.queryAllTest2(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "listTest2";
    }

    //查询单条
    @ResponseBody
    @RequestMapping(value = "queryTest2ById",method = RequestMethod.GET,
            produces ="application/json;charset=utf-8")
    public String queryTest2ById(Integer id,Model model){
        Test2 queryTest2=test2Service.queryTest2ById(id);
        return JSON.toJSONString(queryTest2);
    }

    //修改状态byId
    @ResponseBody
    @RequestMapping(value = "updateStatusById",method = RequestMethod.POST,
            produces ="application/json;charset=utf-8")
    public String updateStatusById(Test2 test2){
        int n =test2Service.updateStatus(test2);
        if (n>0) {
            return JSON.toJSONString(Message.success());
        }
        return JSON.toJSONString(Message.failed());
    }
}
