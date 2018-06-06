package dreamertn9527.top.design.future;

import java.util.concurrent.ExecutionException;

import dreamertn9527.top.design.timmer.Timmer;


/**
 * 测试Future的实现
 * @author tangniannian
 * 2018年2月24日下午3:18:57
 */
public class Main {

	public static void main(String[] args) {
		FutureDemo cook = (FutureDemo) Timmer.getObject(FutureDemo.class);
		try {
			cook.cook();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
