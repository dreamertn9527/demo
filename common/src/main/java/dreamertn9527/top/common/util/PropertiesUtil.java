package dreamertn9527.top.common.util;

import dreamertn9527.top.common.cache.JvmCache;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类描述: 获取配置文件工具类
 *
 * @author:tangniannian
 * @date:2018/4/24
 * @修改描述：
 * @modifier ${tags}
 */
public class PropertiesUtil {
    private static Properties prop = null;

    public static String getProperties(String filePath, String key){
        Object val = JvmCache.get(key);
        if(val != null){
            return val.toString();
        }

        try (InputStream inputstream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath)) {
            if (prop == null) {
                prop = new Properties();
            }
            prop.load(inputstream);
            val = prop.getProperty(key);
            if(val == null){
                return null;
            }
            JvmCache.put(key, val);

            return val.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        for(int i = 0; i < 10; i++){
//            System.out.println(getProperties("properties/redis-config.properties", "jedis.pool.maxActive"));
//        }
//    }
}
