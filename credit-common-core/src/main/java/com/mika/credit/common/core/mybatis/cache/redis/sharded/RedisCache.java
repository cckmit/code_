package com.mika.credit.common.core.mybatis.cache.redis.sharded;

import com.mika.credit.common.redis.SerializeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.cache.Cache;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 1 ，只有在SQLMap.xml 文件中添加了 缓存实现类才能生效如下：
 *   <cache eviction="LRU" type="com.mika.credit.common.core.mybatis.cache.redis.MybatiesRedisCache" />
 * 2， 必须是在事务正常提交下才会触发putObject(Object key, Object value) 以列队方式加入缓存 
 * 3，默认的SQLMAP.xml  <select ... flushCache="false" useCache="true"/>
 * 						<insert ... flushCache="true"/>
 * 						<update ... flushCache="true"/>
 * 						<delete ... flushCache="true"/>
 * flushCache= 'true'  表示当前操作 会清空本接口命名空间下的所有缓存
 * 可更改 <select ... useCache="false"> 表示当前操作禁用缓存数据
 * </per>
 * @author mika
 */
public class RedisCache implements Cache {

	private static Log log = LogFactory.getLog(RedisCache.class);
	/** The ReadWriteLock. 什么作用 */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("必须传入ID");
		}
		log.debug("MybatisRedisCache:id=" + id);
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		int result = 0;
//		ShardedJedis jedis = null;
//		ShardedJedisPool jedisPool = null;
//		int result = 0;
//		boolean borrowOrOprSuccess = true;
//		try {
//			jedis = CachePool.getInstance().getJedis();
//			jedisPool = CachePool.getInstance().getJedisPool();
//			result = Integer.valueOf(jedis.dbSize().toString());
//		} catch (JedisConnectionException e) {
//			borrowOrOprSuccess = false;
//			if (jedis != null)
//				jedisPool.returnBrokenResource(jedis);
//		} finally {
//			if (borrowOrOprSuccess)
//				jedisPool.returnResource(jedis);
//		}
		return result;

	}

	@Override
	public void putObject(Object key, Object value) {
		if (log.isDebugEnabled())
			log.debug("putObject:" + key.hashCode() + "=" + value);
		if (log.isInfoEnabled())
			log.info("put to redis sql :" + key.toString());
		ShardedJedis jedis = null;
		ShardedJedisPool jedisPool = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			jedis.set(SerializeUtils.serialize(key.hashCode()), SerializeUtils.serialize(value));
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (borrowOrOprSuccess)
				jedisPool.returnResource(jedis);
		}

	}

	@Override
	public Object getObject(Object key) {
		ShardedJedis jedis = null;
		ShardedJedisPool jedisPool = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			System.out.println(key.hashCode());
			System.out.println(SerializeUtils.serialize(key.hashCode()));
			System.out.println(jedis.get(SerializeUtils.serialize(key.hashCode())));
			value = SerializeUtils.unSerialize(jedis.get(SerializeUtils.serialize(key.hashCode())));
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (borrowOrOprSuccess)
				jedisPool.returnResource(jedis);
		}
		if (log.isDebugEnabled())
			log.debug("getObject:" + key.hashCode() + "=" + value);
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		ShardedJedis jedis = null;
		ShardedJedisPool jedisPool = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			value = jedis.expire(SerializeUtils.serialize(key.hashCode()), 0);
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (borrowOrOprSuccess)
				jedisPool.returnResource(jedis);
		}
		if (log.isDebugEnabled())
			log.debug("getObject:" + key.hashCode() + "=" + value);
		return value;
	}

	@Override
	public void clear() {
//		ShardedJedis jedis = null;
//		ShardedJedisPool jedisPool = null;
//		boolean borrowOrOprSuccess = true;
//		try {
//			jedis = CachePool.getInstance().getJedis();
//			jedisPool = CachePool.getInstance().getJedisPool();
//			jedis.flushDB();
//			jedis.flushAll();
//		} catch (JedisConnectionException e) {
//			borrowOrOprSuccess = false;
//			if (jedis != null)
//				jedisPool.returnBrokenResource(jedis);
//		} finally {
//			if (borrowOrOprSuccess)
//				jedisPool.returnResource(jedis);
//		}
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

}
