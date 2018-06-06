package dreamertn9527.top.lock.redislock;

import dreamertn9527.top.common.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * 类描述:分布式锁实现类
 *
 * @author:tangniannian
 * @date:2018/6/6
 * @修改描述：
 * @modifier ${tags}
 */
public class DistrictedRedisLock extends AbstractDistrictedRedisLock {

    public DistrictedRedisLock(String bussinessId) {
        super(bussinessId);
    }

    /**
     * 加锁
     */
    @Override
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

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        Jedis jedis = JedisUtil.getJedisObject();
        jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(value));
    }

    private boolean tryLock() {
        Jedis jedis = JedisUtil.getJedisObject();
        String result = jedis.set(lockKey, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, EXPIRE_TIME);
        return SUCCESS.equals(result);
    }
}
