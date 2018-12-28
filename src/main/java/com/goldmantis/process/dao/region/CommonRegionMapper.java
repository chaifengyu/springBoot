package com.goldmantis.process.dao.region;

import java.util.List;

import com.goldmantis.process.entity.common.CommonRegion;
import com.goldmantis.process.entity.common.CommonRegionExample;

public interface CommonRegionMapper {
    int countByExample(CommonRegionExample example);

    int deleteByPrimaryKey(String id);

    int insert(CommonRegion record);

    int insertSelective(CommonRegion record);

    List<CommonRegion> selectByExample(CommonRegionExample example);

    CommonRegion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommonRegion record);

    int updateByPrimaryKey(CommonRegion record);
}