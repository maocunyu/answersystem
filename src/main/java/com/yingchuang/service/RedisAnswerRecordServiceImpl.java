package com.yingchuang.service;

import com.yingchuang.dao.RedisAnswerRecordMapper;
import com.yingchuang.entity.RedisAnswerRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/4/4.
 */
@Service
public class RedisAnswerRecordServiceImpl implements RedisAnswerRecordService {
    @Resource
    private RedisAnswerRecordMapper redisAnswerRecordMapper;


    @Override
    public int addAnswerRecord(RedisAnswerRecord redisAnswerRecord) {
        return redisAnswerRecordMapper.addAnswerRecord(redisAnswerRecord);
    }

    @Override
    public List<RedisAnswerRecord> queryAllAnswerRecord() {

        return redisAnswerRecordMapper.queryAllAnswerRecord();
    }

    @Override
    public RedisAnswerRecord checkRecord(RedisAnswerRecord redisAnswerRecord) {
        return redisAnswerRecordMapper.checkRecord(redisAnswerRecord);
    }

    @Override
    public int deleteRecordById(Integer id) {
        return redisAnswerRecordMapper.deleteRecordById(id);
    }
}
