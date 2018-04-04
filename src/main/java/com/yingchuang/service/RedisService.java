package com.yingchuang.service;

import com.yingchuang.entity.RedisAnswerRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/4/3.
 */
public interface RedisService {
    public void addRedis(RedisAnswerRecord redisAnswerRecord);
    public void updateRedis(RedisAnswerRecord redisAnswerRecord);
    public List<RedisAnswerRecord> queryRedis(List<Integer> userid);


}
