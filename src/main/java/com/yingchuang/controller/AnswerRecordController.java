package com.yingchuang.controller;

import com.yingchuang.entity.RedisAnswerRecord;
import com.yingchuang.entity.Users;
import com.yingchuang.service.RedisService;
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

    @RequestMapping("queryRecord")
    public String queryRecordById(HttpSession httpSession,Model model){
        Users user=(Users) httpSession.getAttribute("loginUser");
        Integer userid=user.getId();
        System.out.println(userid);
        List<Integer> id =new ArrayList<>();
        id.add(userid);
        List<RedisAnswerRecord> list=redisService.queryRedis(id);
        if(list!=null){

            for (RedisAnswerRecord redisAnswerRecord : list) {
                System.out.println(redisAnswerRecord);
            }

            model.addAttribute("rList",list);
            return "listRecord";
        }
        model.addAttribute("msg","没有答题记录");
        return "user";
    }



}
