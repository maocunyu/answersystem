package com.yingchuang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yingchuang.entity.RedisAnswerRecord;
import com.yingchuang.entity.Test1;
import com.yingchuang.entity.Test2;
import com.yingchuang.entity.Test3;
import com.yingchuang.service.RedisService;
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
import java.util.Date;
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
    @Resource
    private RedisService redisService;

    @RequestMapping(value = "toTest")
    public String test() {
        return "userTest";
    }


    @ResponseBody
    @RequestMapping(value = "queryTest0ByTestAndPower",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryTest1ByTest(Integer power,String ids,Model model) {
        if (power != null) {
            return JSON.toJSONString(getTest1(power,ids));
        }
        model.addAttribute("msg", "请选择试题类型");
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "queryTest1ByTestAndPower",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryTest2ByTest(Integer power,String ids,Model model) {
        if (power != null) {
            return JSON.toJSONString(getTest2(power,ids));
        }
        model.addAttribute("msg", "请选择试题类型");
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "queryTest2ByTestAndPower",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public String queryTest3ByTest(Integer power,String ids,Model model) {
        if (power != null) {
            return JSON.toJSONString(getTest3(power, ids));
        }
        model.addAttribute("msg", "请选择试题类型");
        return null;
    }

    private Test1 getTest1(Integer power,String ids) {
        System.out.println("power===="+power);
        System.out.println("答过的题string===="+ids);
        Test1 test = new Test1();
        test.setPower(power);
        test.setStatus(1);
        PageInfo<Test1> pageInfo = test1Service.queryTest1ByStatus(1, 1000, test);
        List<Test1> list = pageInfo.getList();
        //list 所有题
        //ids 答过的题 带，的string类型
        //idsInt  答过的题 int
        //idsString 答过的题  不带，的string类型
        //listInt  去掉答过的题id 剩下的id
        List<Integer> listInt = new ArrayList<>();
        if (ids != null && ids !="") {
            String[] idsString = ids.split(",");
            Integer[] idsInt = new Integer[idsString.length];
            for (int i = 0; i < idsString.length; i++) {
                idsInt[i] = Integer.valueOf(idsString[i]);
            }

            for (Test1 test1 : list) {
                listInt.add(test1.getId());
            }
            for (int i = 0; i < idsInt.length; i++) {
                for (int y = 0; y < listInt.size(); y++) {
                    if (idsInt[i] == listInt.get(y)) {
                        listInt.remove(y);
                    }
                }

            }
        } else {
            for (Test1 test11 : list) {
                listInt.add(test11.getId());
            }
        }
        for (Integer integer : listInt) {
            System.out.print(integer+",");
        }
        Test1 test1 = test1Service.queryTest1ById(listInt.get((int) (Math.random() * listInt.size())));
        return test1;
    }

    private Test2 getTest2(Integer power,String ids) {
        System.out.println("power===="+power);
        System.out.println("答过的题string===="+ids);
        Test2 test = new Test2();
        test.setPower(power);
        test.setStatus(1);
        PageInfo<Test2> pageInfo = test2Service.queryTest2ByStatus(1, 1000, test);
        List<Test2> list = pageInfo.getList();
        //list 所有题
        //ids 答过的题 带，的string类型
        //idsInt  答过的题 int
        //idsString 答过的题  不带，的string类型
        //listInt  去掉答过的题id 剩下的id
        List<Integer> listInt = new ArrayList<>();
        if (ids != null && ids !="") {
            String[] idsString = ids.split(",");
            Integer[] idsInt = new Integer[idsString.length];
            for (int i = 0; i < idsString.length; i++) {
                idsInt[i] = Integer.valueOf(idsString[i]);
            }
            for (Test2 test2 : list) {
                listInt.add(test2.getId());
            }
            for (int i = 0; i < idsInt.length; i++) {
                for (int y = 0; y < listInt.size(); y++) {
                    if (idsInt[i] == listInt.get(y)) {
                        listInt.remove(y);
                    }
                }
            }
        } else {
            for (Test2 test22 : list) {
                listInt.add(test22.getId());
            }
        }
        for (Integer integer : listInt) {
            System.out.print(integer);
        }
        Test2 test2 = test2Service.queryTest2ById(listInt.get((int) (Math.random() * listInt.size())));
        return test2;
    }

    private Test3 getTest3(Integer power,String ids) {
        Test3 test = new Test3();
        test.setPower(power);
        test.setStatus(1);
        PageInfo<Test3> pageInfo = test3Service.queryTest3ByStatus(1, 1000, test);
        List<Test3> list = pageInfo.getList();
        List<Integer> listInt = new ArrayList<>();
        if (ids != null && ids !="") {
            String[] idsString = ids.split(",");
            Integer[] idsInt = new Integer[idsString.length];
            for (int i = 0; i < idsString.length; i++) {
                idsInt[i] = Integer.valueOf(idsString[i]);
            }
            for (Test3 test3 : list) {
                listInt.add(test3.getId());
            }
            for (int i = 0; i < idsInt.length; i++) {
                for (int y = 0; y < listInt.size(); y++) {
                    if (idsInt[i] == listInt.get(y)) {
                        listInt.remove(y);
                    }
                }
            }
        } else {
            for (Test3 test33 : list) {
                listInt.add(test33.getId());
            }
        }
        for (Integer integer : listInt) {
            System.out.print(integer);
        }
        Test3 test3 = test3Service.queryTest3ById(listInt.get((int) (Math.random() * listInt.size())));
        return test3;
    }

    @ResponseBody
    @RequestMapping(value = "addRedis",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String addRedis(RedisAnswerRecord redisAnswerRecord) {
        redisAnswerRecord.setTime(new Date());
        redisService.addRedis(redisAnswerRecord);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "updateRedis",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String updateRedis(RedisAnswerRecord redisAnswerRecord) {
        redisAnswerRecord.setTime(new Date());
        redisService.updateRedis(redisAnswerRecord);
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
            test2.setPower(test1.getPower());
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
            test3.setPower(test1.getPower());
            int a=test3Service.addTest3(test3);
            if(a>0){
                return JSON.toJSONString(Message.success());
            }
            return JSON.toJSONString(Message.failed());
        }
        return null;
    }


}
