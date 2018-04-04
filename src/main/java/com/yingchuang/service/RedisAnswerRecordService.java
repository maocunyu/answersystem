package com.yingchuang.service;

import com.yingchuang.entity.RedisAnswerRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/4/4.
 */
public interface RedisAnswerRecordService {
    public int addAnswerRecord(RedisAnswerRecord redisAnswerRecord);
    public List<RedisAnswerRecord> queryAllAnswerRecord();
    public RedisAnswerRecord checkRecord(RedisAnswerRecord redisAnswerRecord);
}
