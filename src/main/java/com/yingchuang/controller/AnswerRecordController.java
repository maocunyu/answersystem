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
    public String queryByKey(String userid,String key,Model model){
        RedisAnswerRecord redisAnswerRecord=redisService.queryRedisByKey(userid, key);
        String[] testCode=redisAnswerRecord.getTestCode().split(",");
        String[] userAnswer=redisAnswerRecord.getUserAnswer().split(",");
        if(redisAnswerRecord.getTestStyle()==0){
            for(int i=0;i<50;i++){
                Test1 test1=test1Service.queryTest1ById(Integer.parseInt(testCode[i]));
                model.addAttribute("test"+i+1,test1);
                model.addAttribute("answer"+i+1,userAnswer[i]);
            }
        }else if(redisAnswerRecord.getTestStyle()==1){
            for(int i=0;i<50;i++){
                Test2 test2=test2Service.queryTest2ById(Integer.parseInt(testCode[i]));
                model.addAttribute("test"+i+1,test2);
                model.addAttribute("answer"+i+1,userAnswer[i]);
            }
        }else if(redisAnswerRecord.getTestStyle()==2){
            for(int i=0;i<50;i++){
                Test3 test3=test3Service.queryTest3ById(Integer.parseInt(testCode[i]));
                model.addAttribute("test"+i+1,test3);
                model.addAttribute("answer"+i+1,userAnswer[i]);
            }
        }
        return "listAnswer";


    }




}
