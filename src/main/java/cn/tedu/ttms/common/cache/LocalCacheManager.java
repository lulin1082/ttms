package cn.tedu.ttms.common.cache;

import org.apache.shiro.cache.CacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;

/**
 * @Author: lulin
 * @Date: 3/27/2019 8:58 PM
 * @Version 1.0
 */
public class LocalCacheManager implements CacheManager {
    @Override
    public Cache getCache(String name) {
        return null;
    }
    @Override
    public Collection<String> getCacheNames() {
        return null;
    }
/*
    public <K, V>  Cache<K, V> getCache(String s) throws CacheException {
*/

    }
