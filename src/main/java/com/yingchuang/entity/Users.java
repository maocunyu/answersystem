package com.yingchuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Max on 4-2-2018-002.
 */

        /*id int(10) NOT NULL用户id
        username varchar(20) NOT NULL用户名
        password varchar(20) NOT NULL密码
        userCode varchar(20) NOT NULL学号
        phonenum varchar(11) NOT NULL手机号
        logintime date NOT NULL登陆时间
        status int(2) NULL状态*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Integer id,status;
    private String userName,password,userCode,phoneNum;
    private Date loginTime;
}
