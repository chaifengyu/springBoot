package com.goldmantis.process.services.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.goldmantis.process.dao.region.CommonRegionMapper;
import com.goldmantis.process.entity.common.CommonRegion;
import com.goldmantis.process.entity.common.CommonRegionExample;
import com.goldmantis.process.services.common.IRedisService;
import com.goldmantis.process.services.common.RegionService;

@Service
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	private CommonRegionMapper commonRegionMapper;
	@Autowired
	private IRedisService iRedisService;
	@Value("${spring.redis.read.port}")
	private String name;
	@Override
	public List<Map<String, Object>> getRegions() {

		String cache = iRedisService.get("common_pinzhai_regions");
		if(StringUtils.isBlank(cache)||"[]".equals(cache)) {
			List<Map<String, Object>> result = new ArrayList<>();
			CommonRegionExample example1 = new CommonRegionExample();
			example1.createCriteria().andLevelEqualTo(1);
			CommonRegion com = new CommonRegion();
			com.setName(name);
//			List<CommonRegion> provinces = commonRegionMapper.selectByExample(example1);
			List<CommonRegion> provinces = new ArrayList<CommonRegion>();
			provinces.add(com);
//			CommonRegionExample example2 = new CommonRegionExample();
//			example2.createCriteria().andLevelEqualTo(2);
//			List<CommonRegion> cities = commonRegionMapper.selectByExample(example2);
//			CommonRegionExample example3 = new CommonRegionExample();
//			example3.createCriteria().andLevelEqualTo(3);
//			List<CommonRegion> regions = commonRegionMapper.selectByExample(example3);
			provinces.stream().forEach(province ->{
				Map map = new HashMap();
				map.put("name",province.getName());
				result.add(map);
			});
//			provinces.stream().forEach(province -> {
//				Map<String,Object> provinceMap = new HashMap<>();
//				provinceMap.put("id", province.getId());
//				provinceMap.put("name", province.getName());
//				List<Map<String, Object>> cityList = new ArrayList<>();
//				List<CommonRegion> cityTemp = cities.stream().filter(city -> city.getParentId().equals(province.getId()))
//					.collect(Collectors.toList());
//				cityTemp.stream().forEach(city -> {
//					List<Map<String, Object>> regionList = new ArrayList<>();
//					Map<String,Object> cityMap = new HashMap<>();
//					cityMap.put("id", city.getId());
//					cityMap.put("name", city.getName());
//					List<CommonRegion> regionTemp = regions.stream().filter(region -> region.getParentId().equals(city.getId())).collect(Collectors.toList());
//					regionTemp.stream().forEach(region -> {
//						Map<String,Object> regionMap = new HashMap<>();
//						regionMap.put("id", region.getId());
//						regionMap.put("name", region.getName());
//						regionList.add(regionMap);
//					});
//					cityMap.put("regionList", regionList);
//					cityList.add(cityMap);
//				});
//				provinceMap.put("cityList", cityList);
//				result.add(provinceMap);
//			});
			iRedisService.set("common_pinzhai_regions", JSON.toJSONString(result));
			return result;
		}
		return JSON.parseObject(cache,  new TypeReference<List<Map<String,Object>>>(){});
	}

}
