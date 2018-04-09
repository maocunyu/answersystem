package com.yingchuang.command;

import com.yingchuang.entity.RedisAnswerRecord;
import com.yingchuang.service.RedisAnswerRecordService;
import com.yingchuang.service.RedisService;
import com.yingchuang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
@Configuration
@EnableScheduling
@Slf4j
@Component
public class RedisUpdateMysql {
    @Resource
    private RedisService redisService;
    @Resource
    private RedisAnswerRecordService redisAnswerRecordService;
    @Resource
    private UserService userService;

    @Scheduled(cron = "0/5 * * * * *")
    public void RedisToMysql(){
        //查redis
        System.out.println("定时任务");
        List<Integer> userid=userService.queryAllUserid();
        List<RedisAnswerRecord> list=redisService.queryRedis(userid);
        for (RedisAnswerRecord redisAnswerRecord : list) {
            RedisAnswerRecord check=redisAnswerRecordService.checkRecord(redisAnswerRecord);
            if(check!=null){
                System.out.println("有重复数据");
            }else{
                redisAnswerRecordService.addAnswerRecord(redisAnswerRecord);
            }
        }
    }
    @Scheduled(cron = "* * * 1 * *")
    public void UpdateMySql(){
        List<RedisAnswerRecord> list=redisAnswerRecordService.queryAllAnswerRecord();
        for (RedisAnswerRecord redisAnswerRecord : list) {
            String testCode=redisAnswerRecord.getTestCode();
            String[] testId=testCode.split(",");
            if(testId.length!=20){
                System.out.println("删除不符合长度的数据");
                redisAnswerRecordService.deleteRecordById(redisAnswerRecord.getId());
            }
        }

    }





}
