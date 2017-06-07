package com.mika.credit.common.core.mybatis.cache.redis.sharded;

import com.mika.credit.common.redis.sharded.RedisUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * 
 * @author mika
 */
public class CachePool {

    ShardedJedisPool pool;
     private static final CachePool cachePool = new CachePool();
     private RedisUtils redisUtils = new RedisUtils();
     
     /**单例模式*/
     public static CachePool getInstance(){
             return cachePool;  
     }  
     
     /**初始化*/
     private CachePool() {  
              pool = redisUtils.getShardedJedisPool();
     }  
     
     public ShardedJedis getJedis(){
         ShardedJedis jedis = null;
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
       
     public ShardedJedisPool getJedisPool(){
             return this.pool;  
     }  
}
