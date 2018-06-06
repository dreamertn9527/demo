package dreamertn9527.top.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.util.concurrent.TimeUnit;

/**
 * 类描述: guava缓存
 *
 * @author:tangniannian
 * @date:2018/6/6
 * @修改描述：
 * @modifier ${tags}
 */
public class JvmCache {
    private static Cache<Object, Object> cache = CacheBuilder.newBuilder()
            // 设置最大并发级别
            .concurrencyLevel(8)
            // 设置最大容量
            .maximumSize(100)
            // 设置过期时间为60分钟
            .expireAfterWrite(60, TimeUnit.MINUTES)
            // 设置要统计缓存的命中率
            .recordStats()
            // 设置key为弱引用类型
            .weakKeys()
            // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build(new CacheLoader<Object, Object>() {
                @Override
                public String load(Object o) throws Exception {
                    return null;
                }
            });

    public static void put(Object key, Object val) {
        cache.put(key, val);
    }

    public static Object get(Object key) {
        //获取数据，如果不存在返回null
        return cache.getIfPresent(key);
    }
}
