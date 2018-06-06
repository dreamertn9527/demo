package dreamertn9527.top.design.proxy.cglib;

/**
 * 测试类
 * @author tangniannian
 *
 */
public class Main {

	/**
	 * JDK的动态代理是通过接口类进行强制转换的
	 * 生成以后的代理对象，可以强制转换为接口
	 * 
	 * CGLIB的动态代理对象是通过生成一个被代理的子类，然后重写父类方法
	 * 生成以后的对象，可以强制转换为被代理对象(也就是用自己写的类)
	 * 子类引用赋值给父类
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DemoPerson obj = (DemoPerson)new SelfMeipo().getInstance(DemoPerson.class);
			obj.findLove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
