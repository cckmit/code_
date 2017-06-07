package com.mika.credit.common.core.mybatis.cache.redis.sentinel;

import com.mika.credit.common.redis.sentinel.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * 
 * @author mika
 */
public class CachePool {

	JedisSentinelPool pool;  
     private static final CachePool cachePool = new CachePool();
     private RedisUtils redisUtils = new RedisUtils();
     
     /**单例模式*/
     public static CachePool getInstance(){
             return cachePool;  
     }  
     
     /**初始化*/
     private CachePool() {  
              pool = redisUtils.getJedisSentinelPool();
     }  
     
     public  Jedis getJedis(){  
             Jedis jedis = null;  
             boolean borrowOrOprSuccess = true;  
             try {  
                     jedis = pool.getResource();  
             } catch (JedisConnectionException e) {  
                     borrowOrOprSuccess = false;  
                     if (jedis != null)  
                             pool.returnBrokenResource(jedis);  
             } finally {  
                     if (borrowOrOprSuccess)  
                             pool.returnResource(jedis);  
             }  
             jedis = pool.getResource();  
             return jedis;  
     }  
       
     public JedisSentinelPool getJedisPool(){  
             return this.pool;  
     }  
}
