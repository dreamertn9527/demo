package dreamertn9527.top.design.factory.methodfactory;

/**
 * 工厂方法模式
 * 各自生产各自的，都拥有各自的工厂
 * @author tangniannian
 *
 */
public class Main {
	public static void main(String[] args) {
		
		// 工厂方法模式
		MethodFactory factory = new AudiFactory();
		System.out.println(factory.getCar().getName());
	}
}
