package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.yingchuang.entity.Test1;
import com.yingchuang.entity.Test2;
import com.yingchuang.entity.Test3;
import com.yingchuang.service.Test1Service;
import com.yingchuang.service.Test2Service;
import com.yingchuang.service.Test3Service;
import com.yingchuang.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/4/4.
 */
@RequestMapping("test")
@Controller
public class TestController {
    @Resource
    private Test1Service test1Service;
    @Resource
    private Test2Service test2Service;
    @Resource
    private Test3Service test3Service;

    @ResponseBody
    @RequestMapping(value = "uploadTest",method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    public String uploadTest(Test1 test1,Integer teststyle){
        System.out.println(test1);
        if(teststyle==0){
            int a=test1Service.addTest1(test1);
            if(a>0){
                return JSON.toJSONString(Message.success());
            }
            return JSON.toJSONString(Message.failed());
        }
        if(teststyle==1){
            Test2 test2=new Test2();
            test2.setQuestion(test1.getQuestion());
            test2.setAnswerA(test1.getAnswerA());
            test2.setAnswerB(test1.getAnswerB());
            test2.setAnswerC(test1.getAnswerC());
            test2.setAnswerD(test1.getAnswerD());
            test2.setRightAnswer(test1.getRightAnswer());
            int a=test2Service.addTest2(test2);
            if(a>0){
                return JSON.toJSONString(Message.success());
            }
            return JSON.toJSONString(Message.failed());
        }
        if(teststyle==2){
            Test3 test3=new Test3();
            test3.setQuestion(test1.getQuestion());
            test3.setAnswerA(test1.getAnswerA());
            test3.setAnswerB(test1.getAnswerB());
            test3.setAnswerC(test1.getAnswerC());
            test3.setAnswerD(test1.getAnswerD());
            test3.setRightAnswer(test1.getRightAnswer());
            int a=test3Service.addTest3(test3);
            if(a>0){
                return JSON.toJSONString(Message.success());
            }
            return JSON.toJSONString(Message.failed());
        }
        return null;
    }
}
