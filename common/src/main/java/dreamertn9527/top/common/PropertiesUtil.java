package dreamertn9527.top.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 类描述: 获取配置文件工具类
 *
 * @author:tangniannian
 * @date:2018/4/24
 * @修改描述：
 * @modifier ${tags}
 */
public class PropertiesUtil {

    private static volatile Properties prop = null;

    private static Cache<Object, String> cache = CacheBuilder.newBuilder()
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
            .build(new CacheLoader<Object, String>() {
                  @Override
                  public String load(Object o) throws Exception {
                      return null;
                  }
              });

    public static void put(Object key, String val) {
        cache.put(key, val);
    }

    public static String get(Object key) {
        //获取数据，如果不存在返回null
        return cache.getIfPresent(key);
    }

    public static String getProperties(String filePath, String key){
        String val = get(key);
        if(val != null){
            return val;
        }

        try (InputStream inputstream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath)) {
            if (prop == null) {
                prop = new Properties();
            }
            prop.load(inputstream);
            val = prop.getProperty(key);
            put(key, val);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return val;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(getProperties("properties/redis-config.properties", "jedis.pool.maxActive"));
        }
    }

}
