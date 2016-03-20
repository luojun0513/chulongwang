package com.clw.core.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.JedisPubSub;

import com.clw.core.common.RedisException;

public interface RedisDao {

	/**
	 * @Title: set
	 * @Description: TODO
	 * @date 2015年3月24日 下午7:34:33
	 * @author 201501295088
	 * @param key
	 * @param value
	 * @throws RedisException
	 */
	public void set(String key, String value) throws RedisException;

	/**
	 * @Title: get
	 * @Description: TODO
	 * @date 2015年3月24日 下午7:34:37
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public String get(String key) throws RedisException;

	/**
	 * @Title: lpush
	 * @Description: redis List 左边push
	 * @date 2015年3月20日 下午3:19:18
	 * @author 201501295088
	 * @param key
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public boolean lpush(String key, String value) throws RedisException;

	/**
	 * @Title: rpop
	 * @Description: redis List 右边pop
	 * @date 2015年3月20日 下午3:20:03
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public String rpop(String key) throws RedisException;

	/**
	 * @Title: lremAllTheSame
	 * @Description: redis list 移除列表中所以与给到value一致的元素
	 * @date 2015年3月20日 下午3:37:01
	 * @author 201501295088
	 * @param key
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public boolean lremAllTheSame(String key, String value) throws RedisException;

	/**
	 * @Title: zadd
	 * @Description: redis SortedSet 增加带有权重的元素
	 * @date 2015年3月20日 下午3:27:22
	 * @author 201501295088
	 * @param key
	 * @param score
	 *          权重
	 * @param member
	 * @return
	 * @throws RedisException
	 */
	public boolean zadd(String key, double score, String member) throws RedisException;

	/**
	 * @Description: 有时效的zadd
	 * @author 201504015319
	 * @date 2015年6月11日下午9:03:44
	 * @param key
	 * @param score
	 * @param member
	 * @param ttls
	 * @return
	 * @throws RedisException
	 */
	public boolean zaddExpire(String key, double score, String member, int ttls) throws RedisException;

	/**
	 * @Title: zrem
	 * @Description: redis SortedSet 移除元素
	 * @date 2015年3月20日 下午4:58:46
	 * @author 201501295088
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 * @throws RedisException
	 */
	public boolean zrem(String key, String... members) throws RedisException;

	/**
	 * @Title: zrange
	 * @Description: TODO
	 * @date 2015年3月24日 下午9:39:15
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public Set<String> zrange(String key) throws RedisException;

	/**
	 * @Title: del
	 * @Description: redis delete 一个指定key value
	 * @date 2015年3月20日 下午3:30:56
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public boolean del(String key) throws RedisException;

	/**
	 * @Title: incr
	 * @Description:将 key 中储存的数字值增一。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR 操作。
	 * @date 2015年3月23日 上午10:16:16
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public long incr(String key) throws RedisException;

	/**
	 * @Title: incrWithExpire
	 * @Description: 将 key 中储存的数字值增一。如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCR
	 *               操作，并设置股过期时间
	 * @date 2015年3月23日 上午10:36:20
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public long incr(String key, int ttls) throws RedisException;

	/**
	 * @Title: sadd
	 * @Description: redis set add
	 * @date 2015年3月24日 下午7:32:01
	 * @author 201501295088
	 * @param key
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public boolean sadd(String key, String value) throws RedisException;

	/**
	 * @Description: 有时效的sadd
	 * @author 201504015319
	 * @date 2015年5月6日下午9:26:33
	 * @param key
	 * @param value
	 * @param ttls
	 * @return
	 * @throws RedisException
	 */
	public boolean saddExpire(String key, String value, int ttls) throws RedisException;

	/**
	 * @Title: srem
	 * @Description: redis set remove
	 * @date 2015年3月24日 下午7:32:14
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public boolean srem(String key, String value) throws RedisException;

	/**
	 * @Title: smembers
	 * @Description: TODO
	 * @date 2015年3月24日 下午9:02:56
	 * @author 201501295088
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public Set<String> smembers(String key) throws RedisException;

	/**
	 * @Description: 随机获取set集合中的一个元素
	 * @author 201504015319
	 * @date 2015年4月24日下午5:14:27
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public String spop(String key) throws RedisException;

	/**
	 * @Description: 获取set集合的长度
	 * @author 201504015319
	 * @date 2015年5月5日下午6:28:10
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public Long getSetSize(String key) throws RedisException;

	/**
	 * @Description: 设置一个key的过期时间
	 * @author 201504015319
	 * @date 2015年5月20日下午10:46:04
	 * @param key
	 * @param seconds
	 * @throws RedisException
	 */
	public void expire(String key, int seconds) throws RedisException;
	
	/**
	 * EXPIREAT 的作用和 EXPIRE 类似，都用于为 key 设置生存时间
	 * 不同在于 EXPIREAT 命令接受的时间参数是 UNIX 时间戳(unix timestamp)
	 * @param key
	 * @param timestamp
	 * @throws RedisException
	 */
	public void expireat(String key,long timestamp) throws RedisException;

	/**
	 * @Description: 判断元素member是否为key集合中的成员
	 * @author 201504015319
	 * @date 2015年5月20日下午11:10:25
	 * @param key
	 * @param member
	 * @return
	 */
	public boolean sisMember(String key, String member) throws RedisException;

	/**
	 * @Description: 获取zset，key集合中member的权值
	 * @author 201504015319
	 * @date 2015年6月11日下午10:14:57
	 * @param key
	 * @param member
	 * @return
	 */
	public double zscore(String key, String member) throws RedisException;

	/**
	 * @Description:为哈希表 key 中的域 field 的值加上增量 increment
	 * @param key
	 * @param field
	 * @param increment
	 * @return
	 * @throws RedisException
	 */
	public long hincrby(String key, String field, long increment) throws RedisException;

	/**
	 * 判断key是否在当前数据库中存在
	 * 
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public long scard(String key) throws RedisException;

	/**
	 * 将哈希表 key 中的域 field 的值设为 value 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作 如果域 field
	 * 已经存在于哈希表中，旧值将被覆盖
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public long hset(String key, String field, String value) throws RedisException;

	/**
	 * 返回哈希表 key 中给定域 field 的值
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public String hget(String key, String field) throws RedisException;

	/**
	 * 将一个 value 插入到列表 key 的表尾(最右边)
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public long rpush(String key, String value) throws RedisException;

	/**
	 * 返回列表 key 中，下标为 index 的元素
	 * 
	 * @param key
	 * @param index
	 * @return
	 * @throws RedisException
	 */
	public String lindex(String key, int index) throws RedisException;

	/**
	 * 返回列表 key 的长度
	 * 
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public long llen(String key) throws RedisException;

	/**
	 * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除
	 * 
	 * @param key
	 * @param start
	 * @param stop
	 * @return
	 * @throws RedisException
	 */
	public String ltrim(String key, int start, int stop) throws RedisException;

	/**
	 * 移除并返回列表 key 的头元素
	 * 
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public String lpop(String key) throws RedisException;

	/**
	 * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定
	 * 
	 * @param key
	 * @param start
	 * @param stop
	 * @return
	 */
	public List<String> lrange(String key, int start, int stop) throws RedisException;

	/**
	 * 返回哈希表 key 中，一个或多个给定域的值
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws RedisException
	 */
	public List<String> hmget(String key, String[] fields) throws RedisException;

	/**
	 * 返回哈希表 key 中，所有域的值
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws RedisException
	 */
	public Map<String, String> hmgetAll(String key) throws RedisException;

	/**
	 * 删除哈希值
	 * 
	 * @param key
	 * @param field
	 * @return 影响条数
	 * @throws RedisException
	 */
	public Long hdel(String key, String field) throws RedisException;

	/**
	 * 哈希是否存在
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws RedisException
	 */
	public boolean hexists(String key, String field) throws RedisException;

	/**
	 * 同时将多个 field-value (域-值)对设置到哈希表 key 中
	 * 
	 * @param key
	 * @param fieldValueMap
	 * @return
	 * @throws RedisException
	 */
	public String hmset(String key, Map<String, String> fieldValueMap) throws RedisException;

	/**
	 * 根据参数 count 的值，移除列表中与参数 value 相等的元素
	 * 
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 * @throws RedisException
	 */
	public long lrem(String key, long count, String value) throws RedisException;
	
	/**
	 * 为有序集 key 的成员 member 的 score 值加上增量 increment
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 * @throws RedisException
	 */
	public double zincrby(String key,double score,String member) throws RedisException;
	
	/**
	 * 返回有序集 key 中，指定区间内的成员。
	 * 其中成员的位置按 score 值递减(从大到小)来排列。
	 * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order)排列。
	 * 除了成员按 score 值递减的次序排列这一点外， ZREVRANGE 命令的其他方面和 ZRANGE 命令一样
	 * @param key
	 * @param start
	 * @param stop
	 * @return
	 * @throws RedisException
	 */
	public Set<String> zrevrange(String key,long start,long stop) throws RedisException;
	
	/**
	 * 返回有序集 key 中，score最大的成员
	 * @param key
	 * @return
	 * @throws RedisException
	 */
	public String zrevrangeMax(String key) throws RedisException;
	
	/**
	 * 订阅给定的一个或多个频道的信息
	 * @param key
	 * @throws RedisException
	 */
	public void subscribe(JedisPubSub jedisPubSub,String key) throws RedisException;
	
	/**
	 * 将信息 message 发送到指定的频道 channel
	 * @param channel
	 * @param message
	 * @throws RedisException
	 */
	public Long publish(String channel,String message) throws RedisException;
	
	public List<String> pubsub(String pattern) throws RedisException;
	
	public void pubsub() throws RedisException;
	
}
