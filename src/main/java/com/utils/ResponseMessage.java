package com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname ResponseMessage
 * @Description TODO
 * @Date 2020/5/12 23:03
 */
public class ResponseMessage {
    private Integer code;//状态码
    private String msg;//状态描述描述
    private Map<String,Object> data=new HashMap<>();//返回数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    //
    public ResponseMessage addObject(String key,Object value){
        this.data.put(key,value);
        return this;
    }
    public static  ResponseMessage success(){
        ResponseMessage rm=new ResponseMessage();
        rm.setCode(200);
        rm.setMsg("处理成功");
        return rm;
    }
    public static  ResponseMessage error(){
        ResponseMessage rm=new ResponseMessage();
        rm.setCode(400);
        rm.setMsg("处理失败");
        return rm;
    }

}
