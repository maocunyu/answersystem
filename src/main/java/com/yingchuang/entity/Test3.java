package com.yingchuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Max on 4-2-2018-002.
 */

        /*id int(10) NOT NULL
        question text NOT NULL问题
        answerA text NOT NULL答案1
        answerB text NOT NULL答案2
        answerC text NOT NULL答案3
        answerD text NOT NULL答案4
        rightanswer int(2) NOT NULL正确答案
        adminId int(11) NOT NULL提交问题及答案管理员名
        status int(2) NULL状态
        power int(2) NULL试题等级*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test3 {
    private Integer id,rightAnswer,status,power,adminId;
    private String question,answerA,answerB,answerC,answerD,questionCode;

}
