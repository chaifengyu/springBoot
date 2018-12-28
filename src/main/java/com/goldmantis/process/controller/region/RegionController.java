package com.goldmantis.process.controller.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goldmantis.process.services.common.RegionService;
import com.goldmantis.process.utils.RequestResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "省市区",tags={"省市区"},hidden=true)
@RequestMapping("region")
public class RegionController {
	
	
	@Autowired
	private RegionService regionService;
	
	@ApiOperation(value="省市区", notes="省市区",hidden=true)
    @RequestMapping(value="getRegions",method = RequestMethod.GET)
    public RequestResult getCount() {
        return RequestResult.ok(regionService.getRegions());
    }

}
