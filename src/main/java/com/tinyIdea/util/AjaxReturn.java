package com.tinyIdea.util;

public class AjaxReturn {
    private String status;
    
    private String msg;
    
    private Object data;
    
    public AjaxReturn(String status, String msg, Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public AjaxReturn(Object data){
        this.status = "OK";
        this.msg = "";
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
