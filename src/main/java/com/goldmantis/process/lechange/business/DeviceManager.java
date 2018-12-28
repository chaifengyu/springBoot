package com.goldmantis.process.lechange.business;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface DeviceManager {

	// 获取指定LiveToken的直播地址信息
	public JSONObject liveInfo(HashMap<String, Object> paramMap);

	// 获取直播状态
	public JSONObject queryLiveStatus(HashMap<String, Object> paramMap);

	// 修改直播状态
	public JSONObject modifyLiveStatus(HashMap<String, Object> paramMap);

	// 设置直播计划开关
	public JSONObject modifyLivePlanStatus(HashMap<String, Object> paramMap);

	// 修改直播计划时间
	public JSONObject modifyLivePlan(HashMap<String, Object> paramMap);

	// 设备解绑
	JSONObject unBindDevice(String code);

	// 设备解绑
	JSONObject unBindDevice(List<String> code);

	String accessToken();

}
