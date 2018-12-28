package com.goldmantis.process.utils;

import java.util.UUID;

import org.joda.time.DateTime;

public enum CodeHelper {
	INSTANCE;
	
	private String codeHeader = "PR";
	
	public String coder(){
		StringBuilder sb = new StringBuilder();
		sb.append(codeHeader);
		DateTime dateTime=new DateTime();
		sb.append(dateTime.toString("yyyyMMddhhmmssSSSa"));
//		StringBuilder waterStr = new StringBuilder();
//		waterStr.append(waterCode.toString());
//		while(waterStr.length()<5){
//			waterStr.insert(0, "0");
//		}
//		sb.append(waterStr);
		return sb.toString();
	}
	
	public String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
