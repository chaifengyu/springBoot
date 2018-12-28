package com.goldmantis.process.lechange.enumeration;

public enum LeChengeResultEnum {
	SUCCESS("0","成功"),
	SN1001("SN1001","签名异常"),
	SN1002("SN1002","签名超时"),
	SN1003("SN1003","签名参数错误"),
	OP1002("OP1002","参数缺失，请确认参数是否有缺失"),
	OP1003("OP1003","参数取值不合法(参数格式有误或为空)，请修正参数值"),
	OP1007("OP1007","无效的方法调用"),
	OP1010("OP1010","应用被冻结。"),
	OP1011("OP1011","当天调用接口次数已达上限。"),
	TK1002("TK1002","token已过期或不存在，请重新获取token。"),
	TK1003("TK1003","非法token，请传入正确的token。");
	private String typeCode;
    private String typeValue;
    private LeChengeResultEnum(String typeCode, String typeValue){
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeValue() {
        return typeValue;
    }
}
