package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.Test1;
import com.yingchuang.entity.Test2;
import com.yingchuang.entity.Test3;
import com.yingchuang.service.Test1Service;
import com.yingchuang.service.Test2Service;
import com.yingchuang.service.Test3Service;
import com.yingchuang.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi on 2018/4/5.
 */
@Controller
@RequestMapping("test")
public class TestController {
    @Resource
    private Test1Service test1Service;
    @Resource
    private Test2Service test2Service;
    @Resource
    private Test3Service test3Service;

    @RequestMapping(value = "toTest")
    public String test() {
        return "userTest";
    }

    @ResponseBody
    @RequestMapping(value = "queryTestByTestAndPower",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryTestByTest(Integer id, Model model) {
        if (id != null) {
            if (id == 1) {
                Test1 test = new Test1();
                test.setPower(1);
                test.setStatus(1);
                PageInfo<Test1> pageInfo = test1Service.queryTest1ByStatus(1, 10, test);
                List<Test1> list = pageInfo.getList();
                List<Integer> listInt = new ArrayList<>();
                for (Test1 test11 : list) {
                    listInt.add(test11.getId());
                }
                Test1 test1 = test1Service.queryTest1ById(listInt.get((int) (Math.random() * listInt.size())));
                return JSON.toJSONString(test1);
            }
            if (id == 2) {
                Test2 test = new Test2();
                test.setPower(1);
                test.setStatus(1);
                PageInfo<Test2> pageInfo = test2Service.queryTest2ByStatus(1, 10, test);
                List<Test2> list = pageInfo.getList();
                List<Integer> listInt = new ArrayList<>();
                for (Test2 test22 : list) {
                    listInt.add(test22.getId());
                }
                Test2 test2 = test2Service.queryTest2ById(listInt.get((int) (Math.random() * listInt.size())));
                return JSON.toJSONString(test2);
            }
            if (id == 3) {
                Test3 test = new Test3();
                test.setPower(1);
                test.setStatus(1);
                PageInfo<Test3> pageInfo = test3Service.queryTest3ByStatus(1, 10, test);
                List<Test3> list = pageInfo.getList();
                List<Integer> listInt = new ArrayList<>();
                for (Test3 test33 : list) {
                    listInt.add(test33.getId());
                }
                Test3 test3 = test3Service.queryTest3ById(listInt.get((int) (Math.random() * listInt.size())));
                return JSON.toJSONString(test3);
            }
        }
        model.addAttribute("msg", "请选择试题类型");
        return null;
    }


    @ResponseBody
    @RequestMapping(value = "uploadTest",method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    public String uploadTest(Test1 test1,Integer teststyle){
        System.out.println(test1);
        System.out.println(teststyle);
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
