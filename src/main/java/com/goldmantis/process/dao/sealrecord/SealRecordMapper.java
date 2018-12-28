package com.goldmantis.process.dao.sealrecord;

import com.goldmantis.process.entity.sealrecord.SealRecord;
import com.goldmantis.process.entity.sealrecord.SealRecordExample;
import java.util.List;

public interface SealRecordMapper {
    int countByExample(SealRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(SealRecord record);

    int insertSelective(SealRecord record);

    List<SealRecord> selectByExample(SealRecordExample example);

    SealRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SealRecord record);

    int updateByPrimaryKey(SealRecord record);
}