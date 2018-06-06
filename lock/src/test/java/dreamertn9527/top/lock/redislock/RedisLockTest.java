package dreamertn9527.top.lock.redislock;

import org.junit.Test;

/**
 * 类描述:
 *
 * @author:tangniannian
 * @date:2018/6/6
 * @修改描述：
 * @modifier ${tags}
 */
public class RedisLockTest {

    private int count = 100;

    private final static String bussinessId = "test";

    private DistrictedRedisLock districtedRedisLock = new DistrictedRedisLock(bussinessId);

    @Test
    public void test(){
        DemoRunnable demoRunnable = new DemoRunnable();
        Thread t1 = new Thread(demoRunnable, "测试A");
        Thread t2 = new Thread(demoRunnable, "测试B");
        Thread t3 = new Thread(demoRunnable, "测试C");
        Thread t4 = new Thread(demoRunnable, "测试D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class DemoRunnable implements Runnable{

        @Override
        public void run() {
            while (count > 0){
                if(count > 0){
                    districtedRedisLock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName()+" 第"+count+"个");
                        count--;

                    } catch (Exception e){}

                    finally {
                        districtedRedisLock.unlock();
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
