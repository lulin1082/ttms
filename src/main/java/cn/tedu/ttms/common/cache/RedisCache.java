package cn.tedu.ttms.common.cache;

import cn.tedu.ttms.common.util.JedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lulin
 * @Date: 3/27/2019 8:56 PM
 * @Version 1.0
 */
@Component
public class RedisCache<K,V> implements Cache<K,V> {

   /* 一、对强一致要求比较高的，应采用实时同步方案，即查询缓存查询不到再从DB查询，保存到缓存；更新时，先更新数据库，再将缓存的设置过期(建议不要去更新缓存内容，直接设置缓存过期)。

    二、对于并发程度较高的，可采用异步队列的方式同步，可采用kafka等消息中间件处理消息生产和消费。*/
  /* @Override
   protected void doUpdate(Session session) {
       // 如果会话过期/停止 没必要再更新了
       if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
           return;
       }
       // 更新session的最后一次访问时间
       UpmsSession upmsSession = (UpmsSession) session;
       UpmsSession cacheUpmsSession = (UpmsSession) doReadSession(session.getId());
       if (null != cacheUpmsSession) {
           upmsSession.setStatus(cacheUpmsSession.getStatus());
           upmsSession.setAttribute("FORCE_LOGOUT", cacheUpmsSession.getAttribute("FORCE_LOGOUT"));
       }
       RedisUtil.set(ZHENG_UPMS_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
       // 更新ZHENG_UPMS_SERVER_SESSION_ID、ZHENG_UPMS_SERVER_CODE过期时间 TODO
       LOGGER.debug("doUpdate >>>>> sessionId={}", session.getId());
   }*/


    @Resource
    JedisUtil jedisUtil;

    private ConcurrentHashMap<byte[],byte[]> concurrentHashMap =new ConcurrentHashMap<byte[], byte[]>();

    private  final String CACHE_PREFIX ="cache_prefix";

    private final static Logger logger = LoggerFactory.getLogger(RedisCache.class);



    @Override
    public V get(K k) throws CacheException {
        byte[] key=getKey(k);
        if(this.concurrentHashMap.containsKey(key)){
            byte[] value=concurrentHashMap.get(key);
            if(value!=null)
            {
                logger.info("从本地内存中获取");
                System.out.println("从本地内存中获取");
                return  (V) SerializationUtils.deserialize(value);
            }
        }else{
            System.out.println("从redis获取");
            logger.info("从redis获取");
            byte[] value2=jedisUtil.get(key);
            if(value2!=null){
                return (V)SerializationUtils.deserialize(value2);
            }
        }
        return  null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        byte[] key=getKey(k);
        byte[] value=SerializationUtils.serialize(v);
       // System.out.println("存入本地内存中");
        this.concurrentHashMap.put(key,value);
        //System.out.println("存入redis中");
        jedisUtil.set(key,value);
        jedisUtil.expire(key,600);
        return  v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key=getKey(k);
        byte[] value=jedisUtil.get(key);
        this.concurrentHashMap.remove(key);

        jedisUtil.delte(key);
        if(value!=null){
            return (V) SerializationUtils.deserialize(value);
        }
        return null;

    }

    @Override
    public void clear() throws CacheException {

       //不要重写
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
       /*
       其实已经有两种类型了，获取不全了
       byte[] key=(this.CACHE_PREFIX+"*").getBytes();
        Set<K> kSet=new HashSet<K>();

       Set<byte[]> keySet= jedisUtil.keys(key);
       if(CollectionUtils.isEmpty(keySet)){
           return kSet;
       }
       for(byte[] keys  :keySet){
           K k=(K) SerializationUtils.deserialize(jedisUtil.get(key));
           kSet.add(k);
       }
       return  kSet;*/
       return null;
    }

    @Override
    public Collection<V> values() {
        //
        return null;
    }



    private byte[ ] getKey (K k){


        if (k instanceof  String){
            return (this.CACHE_PREFIX+k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }
}
