package com.yingchuang.service;

import com.yingchuang.entity.RedisAnswerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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
        redisService.addRedis(new RedisAnswerRecord(0,0,0,1,"CCCCC","Aaaaaaa","TTTTT",new Date()));
    }

    @Test
    public void updateRedis() throws Exception {
        redisService.updateRedis(new RedisAnswerRecord(0,0,0,1,"AAAAAAA","testanswer","useranswer",null));
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