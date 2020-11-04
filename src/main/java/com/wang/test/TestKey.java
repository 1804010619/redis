package com.wang.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author wanglimin
 * @date 2020-11-04 3:07 下午
 */
public class TestKey {
	private Jedis jedis;
	@Before
	public void before(){
		this.jedis = new Jedis("192.168.151.154", 6379);
	}

	@Test
	public void testKeys(){
		Long name = jedis.del("name");
		System.out.println(name);
		Boolean exists = jedis.exists("name");
		System.out.println(exists);
		//设置一个key的超时时间
		//Long expire = jedis.expire("age", 100);
		//System.out.println(expire);
		Long age = jedis.ttl("age");
		System.out.println(age);

		String randomKey = jedis.randomKey();
		System.out.println(randomKey);
//		String rename = jedis.rename("hello", "hallo");
//		System.out.println("rename = " + rename);

		//查看key对应 值得类型
		String type = jedis.type("hallo");
		System.out.println("type = " + type);
		String lists = jedis.type("lists");
		System.out.println("lists = " + lists);
	}



	@After
	public void after(){
		this.jedis.close();
	}

}
