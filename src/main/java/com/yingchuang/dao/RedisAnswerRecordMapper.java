package com.yingchuang.dao;

import com.yingchuang.entity.RedisAnswerRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/4/4.
 */
public interface RedisAnswerRecordMapper {
    public int addAnswerRecord(RedisAnswerRecord redisAnswerRecord);
    public List<RedisAnswerRecord> queryAllAnswerRecord();
    public RedisAnswerRecord checkRecord(RedisAnswerRecord redisAnswerRecord);
    public int deleteRecordById(Integer id);

}
