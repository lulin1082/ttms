package cn.tedu.ttms.common.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @Author: lulin
 * @Date: 3/27/2019 8:55 PM
 * @Version 1.0
 */


public class RedisCacheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
