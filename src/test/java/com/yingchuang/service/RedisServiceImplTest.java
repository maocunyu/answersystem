package com.yingchuang.service;

import com.yingchuang.entity.RedisAnswerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
        redisService.addRedis(new RedisAnswerRecord(0,0,0,1,"BBBBBB","testanswer","useranswer",null));
    }

    @Test
    public void updateRedis() throws Exception {
        redisService.updateRedis(new RedisAnswerRecord(0,0,0,1,"AAAAAAA","testanswer","useranswer",null));
    }

    @Test
    public void queryRedis() throws Exception {
        redisService.queryRedis(new RedisAnswerRecord(0,0,0,2,"testcode","testanswer","useranswer",null));
    }

}