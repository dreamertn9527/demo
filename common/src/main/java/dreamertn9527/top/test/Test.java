package dreamertn9527.top.test;

import com.alibaba.fastjson.JSONObject;
import dreamertn9527.top.common.cache.GuavaCacheDemo;
import dreamertn9527.top.common.util.JedisUtil;

import java.util.concurrent.TimeUnit;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2018/7/30
 * @修改描述：
 * @modifier ${tags}
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(JedisUtil.getJedisClient().get("a"));

        User user = new User();
        user.setName("a");
        user.setAge(18);
        user.setSex("male");

        GuavaCacheDemo guavaCacheDemo = new GuavaCacheDemo();
        guavaCacheDemo.putUser(user);

        user = new User();
        user.setName("b");
        user.setAge(18);
        user.setSex("female");
        guavaCacheDemo.putUser(user);

        for(int i = 0; i < 10; i++){
            User user1 = guavaCacheDemo.getUserByName("a");
            System.out.println(JSONObject.toJSONString(user1));

            User user2 = guavaCacheDemo.getUserByName("b");
            System.out.println(JSONObject.toJSONString(user2));

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
