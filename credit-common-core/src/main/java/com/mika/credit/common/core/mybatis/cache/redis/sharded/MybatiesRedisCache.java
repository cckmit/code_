package com.mika.credit.common.core.mybatis.cache.redis.sharded;

import org.apache.ibatis.cache.decorators.LoggingCache;

/**
 * @author mika
 */
public class MybatiesRedisCache  extends LoggingCache  {

	public MybatiesRedisCache(String id) {  
        super(new RedisCache(id));
	}
}
