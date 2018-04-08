package com.yingchuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/4/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowTest {
    private Integer id,rightAnswer,status,power,adminId;
    private String question,answerA,answerB,answerC,answerD,questionCode,userAnswer;
}
