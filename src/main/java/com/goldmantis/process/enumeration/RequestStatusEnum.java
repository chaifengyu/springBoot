package com.goldmantis.process.enumeration;

public enum RequestStatusEnum {
	SUCCESS(1,"成功"),
    FAILURE(0,"失败"),
    ERROR(500,"错误"),
    FORBIDDEN(403,"禁止访问"),
    ACCESSDENIED(407,"未授权");
    private Integer typeCode;
    private String typeValue;
    private RequestStatusEnum(Integer typeCode, String typeValue){
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
