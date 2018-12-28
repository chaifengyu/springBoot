package com.goldmantis.process.services.sealrecord.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldmantis.process.dao.sealrecord.SealRecordMapper;
import com.goldmantis.process.entity.sealrecord.SealRecord;
import com.goldmantis.process.entity.sealrecord.SealRecordExample;
import com.goldmantis.process.services.sealrecord.SealRecordService;

@Service
public class SealRecordServiceImpl implements SealRecordService {

	@Autowired
	private SealRecordMapper sealRecordMapper;
	
	@Override
	public int countByExample(SealRecordExample example) {
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@Override
	public int insert(SealRecord record) {
		return 0;
	}

	@Override
	public int insertSelective(SealRecord record) {
		return sealRecordMapper.insertSelective(record);
	}

	@Override
	public List<SealRecord> selectByExample(SealRecordExample example) {
		return null;
	}

	@Override
	public SealRecord selectByPrimaryKey(String id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SealRecord record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SealRecord record) {
		return 0;
	}

}
