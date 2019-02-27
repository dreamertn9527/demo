package dreamertn9527.top.lock.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2019/2/28
 * @修改描述：
 * @modifier ${tags}
 */
public class BloomFilterDemo {

    public static void main(String[] args) {
        BloomFilter bloomFilter = BloomFilter.create(
                // 存储数据格式
                Funnels.stringFunnel(Charset.defaultCharset()),
                // 存储数据量
                10000000,
                // 误判率
                0.00000001);
        bloomFilter.put("safdsfffffsasaxazxczxxc");
        for(int i = 0; i < 5000000; i++){
            bloomFilter.put(UUID.randomUUID().toString());
        }

        long start = System.currentTimeMillis();
        System.out.println(bloomFilter.mightContain("safdsfffffsasaxazxczxxc"));
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));

        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bloomFilter.mightContain("safdsfffffsasaxazxczxxc");
    }
}
