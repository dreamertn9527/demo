package dreamertn9527.top.common.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import dreamertn9527.top.common.util.JedisUtil;
import dreamertn9527.top.test.User;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 类描述: guava和redis缓存，实现数据高并发读
 * 目的是为了将数据全部存放在内存中，实现数据的告诉存取
 * 其数据回源可采用异步MQ刷新的方式解决
 *
 * @author:tangniannian
 * @date:2018/7/30
 */
public class GuavaCacheDemo {

    /**
     * JVM最大存取数据条数
     */
    private final static Integer MAX_SIZE = 100;
    /**
     * 过期时间
     */
    private final static Long EXPIRE_TIME = 60L;
    /**
     * 过期时间单位-秒
     */
    private final static TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    /**
     * Guava缓存设置最大并发级别为8
     */
    private final static Integer CONCURRENCY_LEVEL = 8;

    private final static LoadingCache<String, User> cache = CacheBuilder.newBuilder()
            .maximumSize(MAX_SIZE)
            .refreshAfterWrite(EXPIRE_TIME, TIME_UNIT)
            .concurrencyLevel(CONCURRENCY_LEVEL)
            .build(new CacheLoader<String, User>() {
                /**
                 * build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                 */
                @Override
                public User load(String s) throws Exception {
                    Jedis jedis = JedisUtil.getJedisClient();
                    return JSON.parseObject(jedis.get(s), User.class);
                }
            });

    public Boolean putUser(User user){
        int expireTime = 60;
        Jedis jedis = JedisUtil.getJedisClient();
        jedis.setex(user.getName(),  expireTime, JSON.toJSONString(user));
        cache.refresh(user.getName());

        return Boolean.TRUE;
    }

    public User getUserByName(String name){
        User user = null;
        try {
            User temp = cache.get(name);
            if(temp != null && temp.getName() != null){
                user = temp;
            }
        } catch (ExecutionException e) {
            System.out.println(e);
        }

        return user;
    }
}
