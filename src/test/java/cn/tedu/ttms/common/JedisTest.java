package cn.tedu.ttms.common;

import org.junit.Test;
import redis.clients.jedis.JedisPool;

/**
 * @Author: lulin
 * @Date: 3/28/2019 3:26 PM
 * @Version 1.0
 */
public class JedisTest extends BaseDaoTest{

    @Test
    public void TestJediaPool(){
        JedisPool jedisPool =ctx.getBean(JedisPool.class);
        System.out.println(jedisPool.getResource());
    }

}
