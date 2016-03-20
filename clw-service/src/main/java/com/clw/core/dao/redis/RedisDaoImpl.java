package com.clw.core.dao.redis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clw.core.common.RedisException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;
//@Component("redisDaoImpl")
public class RedisDaoImpl implements RedisDao {
	private Logger logger = LoggerFactory.getLogger(RedisDaoImpl.class);

//	@Autowired
	private JedisPool jedisPool;

	@Override
	public void set(String key, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public boolean lpush(String key, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lpush(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public String rpop(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.rpop(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return value;
	}

	@Override
	public boolean zadd(String key, double score, String member) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.zadd(key, score, member);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public boolean del(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public boolean lremAllTheSame(String key, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lrem(key, 0, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public boolean zrem(String key, String... members) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.zrem(key, members);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public long incr(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		long res = 0L;
		try {
			jedis = jedisPool.getResource();
			res = jedis.incr(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return res;
	}

	@Override
	public long incr(String key, int ttls) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		String currStr = null;
		long res = 0L;
		try {
			jedis = jedisPool.getResource();
			currStr = jedis.get(key);
			jedis.incr(key);
			if (currStr == null || "".equals(currStr) || "null".equalsIgnoreCase(currStr)) {
				jedis.expire(key, ttls);
			}
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return res;
	}

	@Override
	public String get(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return value;
	}

	@Override
	public boolean sadd(String key, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;

		try {
			jedis = jedisPool.getResource();
			jedis.sadd(key, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public boolean srem(String key, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.srem(key, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public Set<String> smembers(String key) throws RedisException {
		boolean error = false;
		Set<String> res = new HashSet<String>();
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			res.addAll(jedis.smembers(key));
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return res;
	}

	@Override
	public Set<String> zrange(String key) throws RedisException {
		boolean error = false;
		Set<String> res = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			res = jedis.zrange(key, 0, -1);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return res;
	}

	@Override
	public String spop(String key) throws RedisException {

		boolean error = false;
		Jedis jedis = null;
		String value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.spop(key);
			// 过滤增加过时时增加的"1"
			if ("1".equals(value)) {
				value = "";
			}
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return value;
	}

	@Override
	public Long getSetSize(String key) throws RedisException {

		boolean error = false;
		Jedis jedis = null;
		Long value = null;
		try {
			jedis = jedisPool.getResource();
			value = jedis.scard(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return value;
	}

	@Override
	public boolean saddExpire(String key, String value, int ttls) throws RedisException {

		boolean error = false;
		Jedis jedis = null;

		try {
			jedis = jedisPool.getResource();
			// 获取集合中元素的个数，如果集合为空，则向集合中添加元素后，设置超时时间
			Long currStr = jedis.scard(key);
			if (currStr == 0) {
				jedis.sadd(key, "1");
				currStr = jedis.scard(key);
			}
			if (currStr == 1) {
				jedis.expire(key, ttls);
			}
			jedis.sadd(key, value);

		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public boolean zaddExpire(String key, double score, String member, int ttls) throws RedisException {

		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			// 获取集合中元素的个数，如果集合为空，则向集合中添加元素后，设置超时时间
			Long currStr = jedis.zcard(key);
			if (currStr == 0) {
				jedis.zadd(key, 0, "1");
				currStr = jedis.zcard(key);
			}
			if (currStr == 1) {
				jedis.expire(key, ttls);
			}
			jedis.zadd(key, score, member);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return error;
	}

	@Override
	public void expire(String key, int seconds) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public boolean sisMember(String key, String member) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.sismember(key, member);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public double zscore(String key, String member) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zscore(key, member);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public long hincrby(String key, String field, long increment) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hincrBy(key, field, increment);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public long scard(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Long count = jedis.scard(key);
			return count;
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public long hset(String key, String field, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hset(key, field, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public String hget(String key, String field) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hget(key, field);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public long rpush(String key, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.rpush(key, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public String lindex(String key, int index) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lindex(key, index);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public long llen(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.llen(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public String ltrim(String key, int start, int stop) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.ltrim(key, start, stop);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public String lpop(String key) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lpop(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public List<String> lrange(String key, int start, int stop) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lrange(key, start, stop);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public List<String> hmget(String key, String[] fields) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hmget(key, fields);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public String hmset(String key, Map<String, String> fieldValueMap) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hmset(key, fieldValueMap);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public long lrem(String key, long count, String value) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lrem(key, count, value);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public Map<String, String> hmgetAll(String key) throws RedisException {

		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hgetAll(key);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public Long hdel(String key, String field) throws RedisException {

		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hdel(key, field);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public boolean hexists(String key, String field) throws RedisException {

		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hexists(key, field);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	public double zincrby(String key, double score, String member)throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zincrby(key, score, member);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	public Set<String> zrevrange(String key, long start, long end)throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	public String zrevrangeMax(String key) throws RedisException {
		String result = "";
		Set<String> members = zrevrange(key, 0, 0);
		if(members != null && members.size() > 0){
			for(String member : members){
				result = member;
			}
		}
		return result;
	}

	public void expireat(String key, long timestamp) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.expireAt(key, timestamp);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		
	}

	@Override
	public void subscribe(JedisPubSub jedisPubSub,String channel) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.subscribe(jedisPubSub, channel);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}

	@Override
	public Long publish(String channel, String message) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		Long result = 0L;
		try {
			jedis = jedisPool.getResource();
			result = jedis.publish(channel, message);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return result;
	}

	@Override
	public List<String> pubsub(String pattern) throws RedisException {
		boolean error = false;
		Jedis jedis = null;
		List<String> channelList = new ArrayList<String>();
		try {
			jedis = jedisPool.getResource();
			channelList = jedis.pubsubChannels(pattern);
		} catch (Exception e) {
			error = true;
			throw new RedisException("redis exception", e);
		} finally {
			if (jedis != null) {
				if (error) {
					jedisPool.returnBrokenResource(jedis);
				} else {
					jedisPool.returnResource(jedis);
				}
			}
		}
		return channelList;
	}

	@Override
	public void pubsub() throws RedisException {
		
	}

}
