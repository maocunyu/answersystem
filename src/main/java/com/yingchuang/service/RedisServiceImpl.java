package com.yingchuang.service;

import com.alibaba.fastjson.JSON;
import com.yingchuang.entity.RedisAnswerRecord;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void addRedis(RedisAnswerRecord redisAnswerRecord) {
        //answerRecord1:i
        long redisSize=0;
        HashOperations hashOperations=stringRedisTemplate.opsForHash();
        String a= JSON.toJSONString(redisAnswerRecord);
        int i;
        for(i=0;i>-1;i++){
//            boolean bool=hashOperations.hasKey("answerRecord"+redisAnswerRecord.getUserId()+":",i);
            redisSize= hashOperations.size("answerRecord:"+redisAnswerRecord.getUserId());
            if(redisSize==i){
                i=i+1;
                break;
            }
        }
        hashOperations.put("answerRecord:"+redisAnswerRecord.getUserId(),String.valueOf(i),a);
    }

    @Override
    public void updateRedis(RedisAnswerRecord redisAnswerRecord) {
        long redisSize=0;
        HashOperations hashOperations=stringRedisTemplate.opsForHash();
        String a= JSON.toJSONString(redisAnswerRecord);
        for(int i=1;i>0;i++){
            redisSize= hashOperations.size("answerRecord:"+redisAnswerRecord.getUserId());
            if(redisSize==i){
                break;
            }
        }
        hashOperations.put("answerRecord:"+redisAnswerRecord.getUserId(),String.valueOf(redisSize),a);


    }

    @Override
    public List<RedisAnswerRecord> queryRedis(List<Integer> userid) {
        HashOperations hashOperations=stringRedisTemplate.opsForHash();
        List<RedisAnswerRecord> list=new ArrayList<>();
        for (Integer integer : userid) {
        long redisSize= hashOperations.size("answerRecord:"+integer);
        for(int i=1;i<redisSize+1;i++){
           RedisAnswerRecord query=JSON.parseObject((String) hashOperations.get("answerRecord:"+integer,String.valueOf(i)),RedisAnswerRecord.class);
            list.add(query);
        }
        }
        return list;
    }

    @Override
    public RedisAnswerRecord queryRedisByKey(String userid, String key) {
        HashOperations hashOperations=stringRedisTemplate.opsForHash();
        RedisAnswerRecord redisAnswerRecord=new RedisAnswerRecord();
        redisAnswerRecord=JSON.parseObject((String) hashOperations.get("answerRecord:"+userid,key),RedisAnswerRecord.class);
        return redisAnswerRecord;
    }
}
