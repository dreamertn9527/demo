package dreamertn9527.top.lock.redislock;

/**
 * 类描述:分布式锁
 *
 * @author:tangniannian
 * @date:2018/6/5
 * @修改描述：
 * @modifier ${tags}
 */
public abstract class AbstractDistrictedRedisLock {

    /**
     * key的后缀
     */
    private String LOCK_KEY_SUFFIX = "_LOCK";

    /**
     * redis set单位为秒
     */
    protected static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * set为nx
     */
    protected static final String SET_IF_NOT_EXIST = "NX";

    /**
     * 自旋时间间隔
     */
    protected final static int SLEEP_MILLISECONDS = 4000;

    /**
     * redis setNX成功后返回状态
     */
    protected static final String SUCCESS = "OK";

    /**
     * key有效时间
     */
    protected final static int EXPIRE_TIME = 3000;

    /**
     * redis的key
     */
    protected String lockKey;

    /**
     * redis set的value
     */
    protected final static String value = "0";

    /**
     * lua脚本，原子性
     */
    protected final static String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    /**
     * 禁止使用无参构造方法
     */
    private AbstractDistrictedRedisLock(){}

    /**
     * 设置的key初始化 key为 : bussinessId_LOCK
     * @param bussinessId 业务ID
     */
    public AbstractDistrictedRedisLock(String bussinessId){
        this.lockKey = bussinessId + LOCK_KEY_SUFFIX;
    }

    /**
     * 加锁
     */
    public abstract void lock();

    /**
     * 释放锁
     */
    public abstract void unlock();
}
