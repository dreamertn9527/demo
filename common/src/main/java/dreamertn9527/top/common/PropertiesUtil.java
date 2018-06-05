package dreamertn9527.top.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2018/4/24
 * @修改描述：
 * @modifier ${tags}
 */
public class PropertiesUtil {
    private static volatile Properties prop = null;

    public static String getProperties(String filePath, String key){
        try (InputStream inputstream = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath)) {
            if (prop == null) {
                prop = new Properties();
            }
            prop.load(inputstream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }

}
