package com.goldmantis.process.controller.sealrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goldmantis.process.entity.sealrecord.SealRecord;
import com.goldmantis.process.services.common.IRedisService;
import com.goldmantis.process.services.sealrecord.SealRecordService;
import com.goldmantis.process.utils.RequestResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "印章",tags={"印章"})
@RequestMapping("seal")
public class SealRecordController {
	
	
	@Autowired
	private SealRecordService sealRecordService;
	@Autowired
	private IRedisService iRedisService;
	
	@ApiOperation(value="印章记录保存", notes="印章记录保存")
    @RequestMapping(value="addRecord",method = RequestMethod.POST)
    public RequestResult addRecord(@RequestBody SealRecord sealRecord, @RequestHeader String token) {
//		boolean cache = iRedisService.exists(SystemConstant.PROCESSKEY + token);
//		if (cache) {
//			return RequestResult.accessdenied("TOKEN数据异常");
//		}
		int result = sealRecordService.insertSelective(sealRecord);
		if(result>0)
			return RequestResult.ok("保存成功");
		else
			return RequestResult.failure("保存失败");
    }

}
