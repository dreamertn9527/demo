package dreamertn9527.top.current;


/**
 * 两个线程：
 *   第一个输出 1，3，5，7...
 *   第二个输出 2，4，6，8...
 * 最后输出：1，2，3，4，5，6...
 */
public class WaitNotifyDemo {

    public static final Object OBJECT = new Object();

    public static Boolean IS_A = Boolean.TRUE;

    public static Integer COUNT = 0;

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setName("thread-1");
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.setName("thread-2");
        threadB.start();

    }

}

class ThreadA extends Thread{

    @Override
    public void run() {
        while (WaitNotifyDemo.COUNT < 99){
            synchronized (WaitNotifyDemo.OBJECT){
                if(!WaitNotifyDemo.IS_A){
                    try {
                        WaitNotifyDemo.OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                WaitNotifyDemo.COUNT++;
                System.out.println("Name: " + this.getName() + "-"+ WaitNotifyDemo.COUNT);
                WaitNotifyDemo.IS_A = Boolean.FALSE;
                WaitNotifyDemo.OBJECT.notify();
            }
        }
    }
}

class ThreadB extends Thread{
    @Override
    public void run() {
        while (WaitNotifyDemo.COUNT < 99) {
            synchronized (WaitNotifyDemo.OBJECT) {
                if (WaitNotifyDemo.IS_A) {
                    try {
                        WaitNotifyDemo.OBJECT.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                WaitNotifyDemo.COUNT++;
                System.out.println("Name: " + this.getName() + "-" + WaitNotifyDemo.COUNT);
                WaitNotifyDemo.IS_A = Boolean.TRUE;
                WaitNotifyDemo.OBJECT.notify();
            }
        }
    }
}
