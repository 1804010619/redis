package com.wang.test;

import com.sun.media.sound.SoftTuning;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author wanglimin
 * @date 2020-11-04 3:21 下午
 */
public class TestString {

	private Jedis jedis;
	@Before
	public void before(){
		this.jedis = new Jedis("192.168.151.154", 6379);
	}

	@Test
	public void testString(){
		String set = jedis.set("name", "wanglimin");
		System.out.println("set = " + set);
		String name = jedis.get("name");
		System.out.println("name = " + name);
		String mset = jedis.mset("content", "haoren", "address", "黑龙江");
		System.out.println("mset = " + mset);
		List<String> mget = jedis.mget("content", "address");
		for (String s : mget) {
			System.out.println("s = " + s);
		}
		String s = jedis.getSet("name", "xiaoliu");
		System.out.println("s = " + s);
		Long lists = jedis.strlen("name");
		System.out.println("lists = " + lists);

	}



	@After
	public void after(){
		this.jedis.close();
	}


}
