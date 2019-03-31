package cn.tedu.ttms.common.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: lulin
 * @Date: 3/27/2019 5:41 PM
 * @Version 1.0
 */
public class JedisTest {

    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "lll");
        String value = jedis.get("name");
        jedis.close();
    }

    @Test
    public void testJedisPool()
    {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        /*最大连接  */
        jedisPoolConfig.setMaxTotal(30);
       /*最大空闲连接*/
        jedisPoolConfig.setMaxIdle(10);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis=jedisPool.getResource();
        jedis.set("name", "lll");
        String value = jedis.get("name");
        jedis.close();
    }
}
