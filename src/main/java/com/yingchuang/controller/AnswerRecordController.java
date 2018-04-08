package com.yingchuang.controller;

import com.yingchuang.entity.*;
import com.yingchuang.service.RedisService;
import com.yingchuang.service.Test1Service;
import com.yingchuang.service.Test2Service;
import com.yingchuang.service.Test3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15001 on 2018/4/7.
 */
@RequestMapping("record")
@Controller
public class AnswerRecordController {
    @Resource
    private RedisService redisService;
    @Resource
    private Test1Service test1Service;
    @Resource
    private Test2Service test2Service;
    @Resource
    private Test3Service test3Service;



    @RequestMapping("queryRecord")
    public String queryRecordById(HttpSession httpSession,Model model){
        Users user=(Users) httpSession.getAttribute("loginUser");
        Integer userid=user.getId();
        System.out.println(userid);
        List<Integer> id =new ArrayList<>();
        id.add(userid);
        List<RedisAnswerRecord> list=redisService.queryRedis(id);
        if(list!=null){
            model.addAttribute("rList",list);
            return "listRecord";
        }
        model.addAttribute("msg","没有答题记录");
        return "user";
    }

    @RequestMapping("queryByKey")
    public String queryByKey(String key,HttpSession httpSession,Model model){
        Users users=(Users) httpSession.getAttribute("loginUser");
        RedisAnswerRecord redisAnswerRecord=redisService.queryRedisByKey(String.valueOf(users.getId()), key);
        String[] testCode=redisAnswerRecord.getTestCode().split(",");
        String[] userAnswer=redisAnswerRecord.getUserAnswer().split(",");
        List<ShowTest> tList=new ArrayList<>();

        if(testCode.length<20){
            return "user";
        }
        if(redisAnswerRecord.getTestStyle()==0){

            for(int i=0;i<20;i++){
                Test1 test1=new Test1();
                test1=test1Service.queryTest1ById(Integer.parseInt(testCode[i]));
                ShowTest showTest=new ShowTest();
                showTest.setAdminId(test1.getAdminId());
                showTest.setAnswerA(test1.getAnswerA());
                showTest.setAnswerB(test1.getAnswerB());
                showTest.setAnswerC(test1.getAnswerC());
                showTest.setAnswerD(test1.getAnswerD());
                showTest.setId(test1.getId());
                showTest.setPower(test1.getPower());
                showTest.setQuestion(test1.getQuestion());
                showTest.setQuestionCode(test1.getQuestionCode());
                showTest.setRightAnswer(test1.getRightAnswer());
                showTest.setStatus(test1.getStatus());
                showTest.setUserAnswer(userAnswer[i]);
                tList.add(showTest);
            }
        }
        else if(redisAnswerRecord.getTestStyle()==1){
            for(int i=0;i<20;i++){
                ShowTest showTest=new ShowTest();
                Test2 test2=test2Service.queryTest2ById(Integer.parseInt(testCode[i]));
                showTest.setAdminId(test2.getAdminId());
                showTest.setAnswerA(test2.getAnswerA());
                showTest.setAnswerB(test2.getAnswerB());
                showTest.setAnswerC(test2.getAnswerC());
                showTest.setAnswerD(test2.getAnswerD());
                showTest.setId(test2.getId());
                showTest.setPower(test2.getPower());
                showTest.setQuestion(test2.getQuestion());
                showTest.setQuestionCode(test2.getQuestionCode());
                showTest.setRightAnswer(test2.getRightAnswer());
                showTest.setStatus(test2.getStatus());
                showTest.setUserAnswer(userAnswer[i]);
                tList.add(showTest);
            }
        }else if(redisAnswerRecord.getTestStyle()==2){
            for(int i=0;i<20;i++){
                ShowTest showTest=new ShowTest();
                Test3 test3=test3Service.queryTest3ById(Integer.parseInt(testCode[i]));
                showTest.setAdminId(test3.getAdminId());
                showTest.setAnswerA(test3.getAnswerA());
                showTest.setAnswerB(test3.getAnswerB());
                showTest.setAnswerC(test3.getAnswerC());
                showTest.setAnswerD(test3.getAnswerD());
                showTest.setId(test3.getId());
                showTest.setPower(test3.getPower());
                showTest.setQuestion(test3.getQuestion());
                showTest.setQuestionCode(test3.getQuestionCode());
                showTest.setRightAnswer(test3.getRightAnswer());
                showTest.setStatus(test3.getStatus());
                showTest.setUserAnswer(userAnswer[i]);
                tList.add(showTest);
            }
        }


        model.addAttribute("test",tList);
        return "listAnswer";
    }




}
