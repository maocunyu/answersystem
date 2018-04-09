package com.yingchuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Administrator on 2018/4/3.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisAnswerRecord {
    private Integer id,score,testStyle,userId;
    private String testCode,testAnswer,userAnswer;
    private Date time;

}
