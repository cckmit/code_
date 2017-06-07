package com.mika.credit.common.redis.sharded.springImpl;

import com.alibaba.fastjson.JSON;
import com.mika.credit.common.redis.sharded.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;


/**
 * 
 * ClassName: RedisCache <br/>
 * Function: 根据SPring API 自定义一个缓存类 ，实现Redis 缓存。<br/>
 * @author MIKA
 */

@Component("redisCache")
public class RedisCache implements Cache {

	private static Logger logger = LoggerFactory.getLogger(RedisCache.class);
	/**缓存的命名属性**/
	private String name;

	public RedisUtils cache = new RedisUtils();

	/**
	 * 清空所有的缓存
	 */
	public void clear() {
		logger.info("we dont have clearAll");
	}

	@Override
	public void evict(Object key) {
		cache.del(key);
		logger.info("deleteKey = {}", key);
	}

	/**
	 * 根据Key值获得缓存数据
	 */

	public ValueWrapper get(Object key) {
		ValueWrapper result = null;
		Object thevalue = cache.get(key);
		if (thevalue != null) {
			result = new SimpleValueWrapper(thevalue);
		}
		logger.info("getKey = {}, getObject = {}", key, JSON.toJSONString(result));
		return result;
	}

	@Override
	public <T> T get(Object key, Class<T> aClass) {
		T result = null;
		Object thevalue = cache.get(key);
		if (thevalue != null && aClass != null && !aClass.isInstance(thevalue)) {
			throw new IllegalStateException("Cached value is not of required type [" + aClass.getName() + "]: " + thevalue);
		}
		T value = (T)thevalue;
		logger.info("getKey = {}, getObject = {}", key, JSON.toJSONString(value));
		return value;
	}

	public <T> T get(Object o, Callable<T> callable) {
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getNativeCache() {
		return cache;
	}
	
	/**添加缓存*/
	public void put(Object key, Object value) {
		cache.save(key, value,20000);
		logger.info("getKey = {}, getObject = {}", key, JSON.toJSONString(value));
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		Object thevalue = cache.get(key);
		if (thevalue != null) {
			evict(key);
		}
		cache.save(key, value,20000);
		logger.info("getKey = {}, getObject = {}", key, JSON.toJSONString(value));
		return  new SimpleValueWrapper(value);

	}

	public RedisCache() {
	}

	public RedisCache(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
