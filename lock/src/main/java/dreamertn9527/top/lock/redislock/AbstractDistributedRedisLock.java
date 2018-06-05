package dreamertn9527.top.lock.redislock;

import dreamertn9527.top.common.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2018/6/5
 * @修改描述：
 * @modifier ${tags}
 */
public class AbstractDistributedRedisLock {

    protected static final String LOCK_KEY_SUFFIX = "_LOCK";

    protected static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SUCCESS = "OK";

    private final static int EXPIRE_TIME = 3000;

    private final static int SLEEP_MILLISECONDS = 4000;

    private String lockKey = "LOCK";

    private final static String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void lock(){
        if(!tryLock()){
            try {
                Thread.sleep(SLEEP_MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock();
        }
    }

    public void unlock() {
        Jedis jedis = JedisUtil.getJedisObject();
        String value = threadLocal.get();
        jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(value));
    }

    private boolean tryLock() {
        Jedis jedis = JedisUtil.getJedisObject();
        String value = UUID.randomUUID().toString();
        threadLocal.set(value);
        String result = jedis.set(lockKey, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, EXPIRE_TIME);
        if(result != null && SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
}
