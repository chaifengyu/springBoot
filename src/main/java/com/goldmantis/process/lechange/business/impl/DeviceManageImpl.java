package com.goldmantis.process.lechange.business.impl;


import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.goldmantis.process.lechange.business.DeviceManager;
import com.goldmantis.process.lechange.util.CONST;
import com.goldmantis.process.lechange.util.HttpSendSetParam;
import com.goldmantis.process.services.common.IRedisService;
import com.goldmantis.process.utils.SystemConstant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceManageImpl implements DeviceManager {
    @Autowired
    private IRedisService iRedisService;
    @Autowired
    private UserManagerImpl userManager;
    @Override
    public JSONObject liveInfo(HashMap<String, Object> paramMap) {
        String method = "liveInfo";
        return (JSONObject) HttpSendSetParam.sent(paramMap, method);
    }

    @Override
    public JSONObject queryLiveStatus(HashMap<String, Object> paramMap) {
        String method = "queryLiveStatus";
        return (JSONObject) HttpSendSetParam.sent(paramMap, method);
    }

    @Override
    public JSONObject modifyLiveStatus(HashMap<String, Object> paramMap) {
        String method = "modifyLiveStatus";
        return (JSONObject) HttpSendSetParam.sent(paramMap, method);
    }

    @Override
    public JSONObject modifyLivePlanStatus(HashMap<String, Object> paramMap) {
        String method = "modifyLivePlanStatus";
        return (JSONObject) HttpSendSetParam.sent(paramMap, method);
    }

    @Override
    public JSONObject modifyLivePlan(HashMap<String, Object> paramMap) {
        String method = "modifyLivePlan";
        return (JSONObject) HttpSendSetParam.sent(paramMap, method);
    }

    @Override
    public JSONObject unBindDevice(String code) {
        String method = "unBindDevice";
        HashMap<String, Object> param = new HashMap<>();
        param.put("deviceId", code);
        param.put("token", accessToken());
        return (JSONObject) HttpSendSetParam.sent(param, method);
    }

    @Override
    public JSONObject unBindDevice(List<String> codes) {
        for (String code: codes) {
            unBindDevice(code);
        }
        return new JSONObject();
    }
    @Override
    public String accessToken() {
	    String accessTokenCache = iRedisService.get(SystemConstant.LECHENGEKEY);
		if(StringUtils.isBlank(accessTokenCache)){
	        HashMap<String, Object> paramsMap = new HashMap<String, Object>();
	        paramsMap.put("phone", CONST.PHONE);// 管理员账号
	        JSONObject lechengeJSON = userManager.accessToken(paramsMap);
	        JSONObject jsonResult = lechengeJSON.getJSONObject("result");
	        String code = jsonResult.getString("code");
	        if(!code.equals("0")) {
	        	return code;
	        }
	        JSONObject jsonData = jsonResult.getJSONObject("data");
	        accessTokenCache = jsonData.getString("accessToken");
	        Long expireTime = jsonData.getLong("expireTime") - SystemConstant.LECHENGEEXTIME;
	        iRedisService.set(SystemConstant.LECHENGEKEY, accessTokenCache);
	        iRedisService.expire(SystemConstant.LECHENGEKEY, expireTime);
		}
		return accessTokenCache;
    }
}
