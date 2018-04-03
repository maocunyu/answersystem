package com.yingchuang.command.Message;

/**
 * Created by Administrator on 2018/2/24/024.
 */
public class Message {
    private String code;
    private String msg;

    public  static com.bdqn.util.Message success() {
        com.bdqn.util.Message message=new com.bdqn.util.Message();
        message.setCode("0000");
        message.setMsg("操作成功");
        return message;
    }

    public static com.bdqn.util.Message error() {
        com.bdqn.util.Message message=new com.bdqn.util.Message();
        message.setCode("0001");
        message.setMsg("操作失败");
        return message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
