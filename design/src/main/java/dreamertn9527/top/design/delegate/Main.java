package dreamertn9527.top.design.delegate;

/**
 * 委派模式
 * 不关心过程，只关心结果
 * @author tangniannian
 *
 */
public class Main {

	/**
	 * 看似是Dispatcher在执行，实际上是TargetA在执行
	 * 两者Dispatcher和TargetA之间没有任何关系，只是Dispatcher持有IDelegate的引用
	 * @param args
	 */
	public static void main(String[] args) {
		Dispatcher dispatcher = new Dispatcher(new TargetA());
		dispatcher.doing();
	}
}
