package com.yingchuang.service;

import com.yingchuang.entity.RedisAnswerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceImplTest {
    @Resource
    private RedisService redisService;

    @Test
    public void addRedis() throws Exception {
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        redisService.addRedis(new RedisAnswerRecord(0, 0, 0, 1, "BBBBBB", "testanswer", "useranswer", new Date()));
        redisService.addRedis(new RedisAnswerRecord(0,20,0,2,"1,2,3,4,5,6,1,1,1,1","1,1,1,1,1,1,1,1,1,1","1,1,1,1,1,1,1,1,1,1",new Date()));
    }

    @Test
    public void updateRedis() throws Exception {
        redisService.updateRedis(new RedisAnswerRecord(0,0,0,2,"1,2,3,4,5,6,1,1,1,1","1,1,1,1,1,1,1,1,1,1","1,1,1,1,1,1,1,1,1,1",null));
    }

    @Test
    public void queryRedis() throws Exception {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        List<RedisAnswerRecord> list1=redisService.queryRedis(list);
        for (RedisAnswerRecord answerRecord : list1) {
            System.out.println(answerRecord);
        }
    }

}