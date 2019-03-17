package dreamertn9527.top.thread;

/**
 * 原子性
 */
public class AtomicDemo {

    private static int a = 0;

    private static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++){
            new Thread(AtomicDemo::inc).start();
        }
        Thread.sleep(4000);

        System.out.println(a);
    }
}
