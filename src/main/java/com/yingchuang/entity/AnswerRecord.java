package com.yingchuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Max on 4-2-2018-002.
 */

        /*id int(11) NOT NULL
        testCode text NOT NULL单次回答的50道题编号
        testAnswer varchar(50) NOT NULL50道题的正确答案
        userAnswer varchar(50) NOT NULL用户的答案
        score int(3) NULL
        userid int(11) NOT NULL答题的用户的id
        time datetime NULL本次答题时间
        testStyle int(10) NULL这列属于哪个表的题*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRecord {
    private Integer id,score,testStyle;
    private String testCode,testAnswer,userAnswer;
    private Date time;
    private Users users;
}
