package com.yingchuang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Max on 4-2-2018-002.
 */

        /*id int(10) NOT NULL
        adminName varchar(20) NOT NULL管理员用户名
        apassword varchar(20) NOT NULL管理员密码
        power int(2) NOT NULL权限
        alogintime date NOT NULL登陆时间
        adminCode varchar(20) NULL员工编号
        status int(2) NULL状态*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id,power,status;
    private String adminName,apassword,adminCode;
    private Date aloginTime;
}
