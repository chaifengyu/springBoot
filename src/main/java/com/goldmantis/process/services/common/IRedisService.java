package com.goldmantis.process.services.common;

public interface IRedisService {
	public void set(String key, String value);
    public String get(String key);
    public boolean expire(String key,long expire);
	Boolean exists(String key);
	Long addSet(String key, String[] values);
	Long addSet(String key, String value);
	String pop(String key);
	Boolean isMember(String key, String value);
	void delete(String key);
}
