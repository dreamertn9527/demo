package dreamertn9527.top;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        try {
            countDownLatch.await();
            ExecutorService executorService = Executors.newFixedThreadPool(11);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World!" );
    }
}
