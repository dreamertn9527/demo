package dreamertn9527.top.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptDemo {

    private static Integer i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){
                i++;
                boolean in = Thread.currentThread().isInterrupted();
                if(in){
                    System.out.println("before: " + in);
                    System.out.println("i:" + i);
                    Thread.interrupted();

                    System.out.println("after: " + Thread.currentThread().isInterrupted());
                    System.out.println("i:" + i);
                }
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
