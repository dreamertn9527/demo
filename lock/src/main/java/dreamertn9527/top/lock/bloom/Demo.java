package dreamertn9527.top.lock.bloom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2019/2/28
 * @修改描述：
 * @modifier ${tags}
 */
public class Demo {
    public static void main(String[] args) {
        String[] strings = new String[5000000];
        for(int i = 0; i < 5000000; i++){
            strings[i] = (UUID.randomUUID().toString());
        }

        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(strings[0]);
    }
}
