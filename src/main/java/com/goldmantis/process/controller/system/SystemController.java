package com.goldmantis.process.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goldmantis.process.utils.DESAlgorithmUtilFactory;
import com.goldmantis.process.utils.RequestResult;
import com.goldmantis.process.utils.SystemConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(value = "系统功能",tags={"系统功能，登录等"},hidden=true)
@RequestMapping("system")
public class SystemController {
    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

	
	@Autowired
	private com.goldmantis.process.services.common.IRedisService iRedisService;
	
	@ApiOperation(value="生成TOKEN", notes="生成TOKEN",hidden=true)
	@ApiImplicitParam(name = "sign", value = "签名", required = true, dataType = "String",paramType="body")
	@RequestMapping(value="token",method = RequestMethod.POST)
    public RequestResult login(@RequestBody String sign) {
         try {
        	 
        	String token = DESAlgorithmUtilFactory.decryptString(sign);
			iRedisService.set(SystemConstant.PROCESSKEY, token);
			return RequestResult.ok(token);
		} catch (Exception e) {
			e.printStackTrace();
			 return RequestResult.error(e.getMessage());
		}
    }
}