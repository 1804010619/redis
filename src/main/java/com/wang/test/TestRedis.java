package com.wang.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author wanglimin
 * @date 2020-11-04 3:01 下午
 * 测试redis连接
 */
public class TestRedis {
	public static void main(String[] args) {
		//连接redis
		Jedis jedis = new Jedis("192.168.151.154",6379);
		//选择数据库
		jedis.select(0);
		Set<String> keys = jedis.keys("*");
		keys.forEach(key->{
			System.out.println("key=="+key);
		});

		//操作库
		jedis.flushAll();

		jedis.close();
	}
}
