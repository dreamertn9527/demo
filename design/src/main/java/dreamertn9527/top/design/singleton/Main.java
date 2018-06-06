package dreamertn9527.top.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(16);
//		exec.execute(new Demo());
		for(int i = 0; i < 2000; i++){
			exec.execute(new Demo());
		}
	}
	
	
}

class Demo implements Runnable{

	@Override
	public void run() {
		System.out.println(DoubleCheckSingleton.getInstance().hashCode());
		System.out.println(StaticInnerClassSingleton.getInstance());
	}
	
}
