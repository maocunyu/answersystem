package com.yingchuang.command;

import com.yingchuang.entity.*;

/**
 * Created by Administrator on 2018/4/3.
 */
public class AutoCode {

    public String autoAdminCode(Admin admin,Integer adminNum) {
        String id = String.valueOf(admin.getId());
        if (id.length() < 4) {
            for (int i = 1; i < 4 - id.length(); i++) {
                id = "0" + id;
            }
        }
        String power = String.valueOf(admin.getPower());
        if (id.length() < 2) {
            power = "0" + power;
        }
        String num= String.valueOf(adminNum);
        if(num.length()<6){
            for(int i=0;i<5;i++){
                num="0"+num;
            }
        }
        String adminCode=id+power+num;
        return adminCode;
    }

    public String autoTest1Code(Test1 test1){
        String id= String.valueOf(test1.getId());
        if (id.length() < 4) {
            for (int i = 1; i < 4 - id.length(); i++) {
                id = "0" + id;
            }
        }
        String answer= String.valueOf(test1.getRightAnswer());
        answer="0"+answer;
        String power="0"+test1.getPower();
        String adminId= String.valueOf(test1.getAdminId());
        if (adminId.length() < 2) {
            adminId="0"+adminId;
        }
        String test1Code="01"+id+answer+power+adminId;
        return test1Code;
    }

    public String autoTest2Code(Test2 test2){
        String id= String.valueOf(test2.getId());
        if (id.length() < 4) {
            for (int i = 1; i < 4 - id.length(); i++) {
                id = "0" + id;
            }
        }
        String answer= String.valueOf(test2.getRightAnswer());
        answer="0"+answer;
        String power="0"+test2.getPower();
        String adminId= String.valueOf(test2.getAdminId());
        if (adminId.length() < 2) {
            adminId="0"+adminId;
        }
        String test2Code="02"+id+answer+power+adminId;
        return test2Code;
    }


    public String autoTest3Code(Test3 test3){
        String id= String.valueOf(test3.getId());
        if (id.length() < 4) {
            for (int i = 1; i < 4 - id.length(); i++) {
                id = "0" + id;
            }
        }
        String answer= String.valueOf(test3.getRightAnswer());
        answer="0"+answer;
        String power="0"+test3.getPower();
        String adminId= String.valueOf(test3.getAdminId());
        if (adminId.length() < 2) {
            adminId="0"+adminId;
        }
        String test3Code="03"+id+answer+power+adminId;
        return test3Code;
    }

    public String autoUsersCode(Users users,int usersNum){
        String id= String.valueOf(users.getId());
        if (id.length() < 4) {
            for (int i = 1; i < 4 - id.length(); i++) {
                id = "0" + id;
            }
        }
        String phoneNum=users.getPhoneNum().substring(6);
        String num= String.valueOf(usersNum);
        if(num.length()<4){
            for(int i=0;i<3;i++){
                num="0"+num;
            }
        }
        return id+phoneNum+num;
    }




}
