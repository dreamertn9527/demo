package dreamertn9527.top.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 类描述: jedis连接池工具类
 *
 * @author:tangniannian
 * @date:2018/7/31
 */
public class JedisUtil {

    private final static String REDIS_CONFIG = "properties/redis-config.properties";

    private final static String REDIS_IP_KEY = "redis.ip";

    private final static String REDIS_PORT_KEY = "redis.port";

    private static JedisPoolConfig jedisPoolConfig;

    static {
        init();
    }

    private static void init(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.maxActive")));
        config.setMaxWaitMillis(Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.maxWait")));
        config.setMaxIdle(Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.maxIdle")));
        config.setTestOnBorrow(Boolean.valueOf(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(PropertiesUtil.getProperties(REDIS_CONFIG, "jedis.pool.testOnReturn")));


        jedisPoolConfig = config;
    }

    public static Jedis getJedisClient(){
        String ipAddr = PropertiesUtil.getProperties(REDIS_CONFIG, REDIS_IP_KEY);
        int port = Integer.parseInt(PropertiesUtil.getProperties(REDIS_CONFIG, REDIS_PORT_KEY));
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, ipAddr, port);
        return jedisPool.getResource();
    }
}
