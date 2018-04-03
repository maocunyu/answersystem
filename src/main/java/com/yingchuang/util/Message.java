package com.yingchuang.util;

import lombok.Data;

/**
 * Created by Max on 4-3-2018-003.
 */
@Data
public class Message {

    private String code,msg;

    public static Message success(){
        Message message=new Message();
        message.setCode("0000");
        message.setMsg("success");
        return message;
    }

    public static Message failed(){
        Message message =new Message();
        message.setCode("0001");
        message.setMsg("failed");
        return message;
    }


}
