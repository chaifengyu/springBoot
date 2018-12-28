package com.goldmantis.process.services.sealrecord;

import java.util.List;

import com.goldmantis.process.entity.sealrecord.SealRecord;
import com.goldmantis.process.entity.sealrecord.SealRecordExample;

public interface SealRecordService {
	int countByExample(SealRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(SealRecord record);

    int insertSelective(SealRecord record);

    List<SealRecord> selectByExample(SealRecordExample example);

    SealRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SealRecord record);

    int updateByPrimaryKey(SealRecord record);
}
