package com.goldmantis.process.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.goldmantis.process.enumeration.RequestStatusEnum;

public class RequestResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;
    
    // 数据总量
    private long total;
    
    public RequestResult() {
    	super();
    }

    public RequestResult(Integer status, String message, Object data) {
    	super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public RequestResult(Object data) {
    	super();
        this.status = 1;
        this.message = "success";
        this.data = data;
    }
    
    public static RequestResult build(Integer status, String msg, Object data) {
        return new RequestResult(status, msg, data);
    }

    public static RequestResult ok(Object data) {
        return new RequestResult(data);
    }

    public static RequestResult ok() {
        return new RequestResult(null);
    }
    
    public static RequestResult ok(Object data, long total){
    	RequestResult requestResult = new RequestResult();
    	requestResult.setData(data);
    	requestResult.setTotal(total);
    	return requestResult;
    }
    
    public static RequestResult failure(String message){
    	return new RequestResult(RequestStatusEnum.FAILURE.getTypeCode(), message, null);
    }
    
    public static RequestResult error(String message){
    	return new RequestResult(RequestStatusEnum.ERROR.getTypeCode(), message, null);
    }
    
    public static RequestResult forbidden(String message){
    	return new RequestResult(RequestStatusEnum.FORBIDDEN.getTypeCode(), message, null);
    }
    
    public static RequestResult accessdenied(String message){
    	return new RequestResult(RequestStatusEnum.ACCESSDENIED.getTypeCode(), message, null);
    }
    
    public static RequestResult build(Integer status, String msg) {
        return new RequestResult(status, msg, null);
    }

    public Integer getStatus() {
        return status;
    }

    public RequestResult setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return message;
    }

    public RequestResult setMsg(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RequestResult setData(Object data) {
        this.data = data;
        return this;
    }

	public long getTotal() {
		return total;
	}

	public RequestResult setTotal(long total) {
		this.total = total;
		return this;
	}
	
	public String toJson() {
	    return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue,
	    		SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteDateUseDateFormat); 
    }
}
