package dreamertn9527.top.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 类描述: jedis连接池工具类
 *
 * @author:tangniannian
 * @date:2018/6/5
 * @修改描述：
 * @modifier ${tags}
 */
public class JedisUtil {

    private static JedisPool pool;

    private final static String REDIS_CONFIG = "properties/redis-config.properties";

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.maxActive")));
        config.setMaxWaitMillis(Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.maxWait")));
        config.setMaxIdle(Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.maxIdle")));
        config.setTestOnBorrow(Boolean.valueOf(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.testOnReturn")));

        pool = new JedisPool(config, PropertiesUtil.getProperties(REDIS_CONFIG, "redis.ip"), Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "redis.port")));
    }

    /**
     * 获得jedis对象
     */
    public static Jedis getJedisObject() {
        return pool.getResource();
    }
}
