package com.goldmantis.process.services.common.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.goldmantis.process.services.common.IRedisService;

@Service
public class RedisServiceImpl implements IRedisService {
	
	@Resource(name="WriteRedisTemplate")  
    private RedisTemplate<String, String> redisWriteTemplate;  
	@Autowired
	@Qualifier("ReadRedisTemplate")
	private RedisTemplate<String, String> redisReadTemplate;  
	
	@Override
	public void set(String key, String value) {
		redisWriteTemplate.opsForValue().set(key, value);
	}

	@Override
	public String get(String key) {
		return redisReadTemplate.opsForValue().get(key);
	}

	@Override
	public boolean expire(String key, long expire) {
		return redisWriteTemplate.expire(key, expire, TimeUnit.SECONDS);  
	}
	
	@Override
	public Boolean exists(final String key){
        return (Boolean) redisReadTemplate.execute(new RedisCallback<Boolean>() {
        	@Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
	}
	
	@Override
	public Long addSet(String key,String[] values) {
		return redisWriteTemplate.opsForSet().add(key,values);
	}
	
	@Override
	public Long addSet(String key,String value) {
		return redisWriteTemplate.opsForSet().add(key,value);
	}
	
	@Override
	public String pop(String key) {
		return redisWriteTemplate.opsForSet().pop(key);
	}
	
	@Override
	public Boolean isMember(String key,String value) {
		return redisReadTemplate.opsForSet().isMember(key,value);
	}
	
	@Override
	public void delete(String key) {
		redisWriteTemplate.delete(key);
	}
}
