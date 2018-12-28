package com.goldmantis.process.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
//@EnableAutoConfiguration  
public class RedisConfig {
	
	private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);  
	
    @Bean(name="ReadRedisConfig")
    @ConfigurationProperties(prefix="spring.redis.read.pool")  
    public JedisPoolConfig getReadRedisConfig(){
        return new JedisPoolConfig();
    }  
      
    @Bean(name="ReadConnectionFactory")
    @ConfigurationProperties(prefix="spring.redis.read")  
    public JedisConnectionFactory getReadConnectionFactory(@Qualifier("ReadRedisConfig")JedisPoolConfig config){  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        factory.setPoolConfig(config);  
        logger.info("JedisConnectionFactory bean init success.");  
        return factory;  
    }  
      
    @Bean(name="ReadRedisTemplate")
    public RedisTemplate<?, ?> getReadRedisTemplate(@Qualifier("ReadConnectionFactory")JedisConnectionFactory jedisConnectionFactory){
    	RedisTemplate<?,?> template = new StringRedisTemplate(jedisConnectionFactory); 
    	logger.info("ReadRedisTemplate bean init success."); 
        return template;
    } 
    
    @Bean(name="WriteRedisConfig")
    @ConfigurationProperties(prefix="spring.redis.write.pool")  
    public JedisPoolConfig getWriteRedisConfig(){  
        return new JedisPoolConfig(); 
    }  
    
    @Bean(name="WriteConnectionFactory")
    @Primary
    @ConfigurationProperties(prefix="spring.redis.write")
    public JedisConnectionFactory getWriteConnectionFactory(@Qualifier("WriteRedisConfig")JedisPoolConfig config){  
    	JedisConnectionFactory factory = new JedisConnectionFactory();  
    	factory.setPoolConfig(config);  
    	logger.info("JedisConnectionFactory bean init success.");  
    	return factory;  
    }  
    
    @Bean(name="WriteRedisTemplate")
    public RedisTemplate<?, ?> getWriteRedisTemplate(@Qualifier("WriteConnectionFactory")JedisConnectionFactory jedisConnectionFactory){
    	return new StringRedisTemplate(jedisConnectionFactory);
    }  
}
