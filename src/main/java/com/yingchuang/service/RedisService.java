package com.yingchuang.service;

import com.yingchuang.entity.AnswerRecord;
import com.yingchuang.entity.RedisAnswerRecord;

/**
 * Created by Administrator on 2018/4/3.
 */
public interface RedisService {
    public void addRedis(RedisAnswerRecord redisAnswerRecord);
    public void updateRedis(RedisAnswerRecord redisAnswerRecord);
    public void queryRedis(RedisAnswerRecord redisAnswerRecord);


}
