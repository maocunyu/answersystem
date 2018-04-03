package com.yingchuang.dao;


import com.yingchuang.entity.AnswerRecord;

/**
 * Created by 朱博文 on 2018/4/3.
 */
public interface AnswerrecordMapper {
    AnswerRecord queryAll(int userid);
    Integer addAnswerrecord(AnswerRecord answerRecord);
}
