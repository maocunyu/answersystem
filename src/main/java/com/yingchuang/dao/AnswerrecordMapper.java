package com.yingchuang.dao;


import com.yingchuang.entity.AnswerRecord;

/**
 * Created by 朱博文 on 2018/4/3.
 */
public interface AnswerrecordMapper {
    //按ID查询记录
    AnswerRecord queryAnswerRecordById(int userid);
    //新增修改记录
    Integer addAnswerrecord(AnswerRecord answerRecord);
}
