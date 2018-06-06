package dreamertn9527.top.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;



/**
 * 通过cglib实现动态代理
 * 代理类媒婆
 * @author tangniannian
 *
 */
public class SelfMeipo implements MethodInterceptor {

	/**
	 * 通过反射实例化传入的类
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public Object getInstance(Class clazz) throws Exception{
		Enhancer enhancer = new Enhancer();
		// 把父类设置为谁
		// 这一步就是告诉cglib，生成的子类需要继承哪个类
		enhancer.setSuperclass(clazz);
		System.out.println(clazz.getClass().getName());
		// 设置回调，调用intercept()方法
		enhancer.setCallback(this);
		
		// 第一步 生成源代码
		// 第二步 生成class文件
		// 加载到jvm找那个，并返回被代理对象
		return enhancer.create();
	}
		
	/**
	 * 字节码重组，相比于jdk自带的代理，使用CGLIB只需要该类即可，不需要写动态代理
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("我是媒婆，得找一个异性给你");
		System.out.println("开始进行海选...");
		System.out.println("------");
		
		// 这个obj的引用是由cglib给我们new出来的
		// CGLIB new出来的对象，是被代理对象的子类(继承了我们自己写的那个类)
		// OOP规定，在new子类之前，实际上默认调用了父类的super()方法的
		// 也就是说new了子类的同时，也必须先初始化父类，这就相当于是间接的持有了父类的引用
		// 子类重写了父类的所有的方法
		// 我们改变子类对象的某些属性，是可以间接的操作父类的属性的
		System.out.println(obj.getClass().getName());

		proxy.invokeSuper(obj, args);
		
		
		System.out.println("------");
		System.out.println("如果合适，就准备在一起");
		
		return null;
	}

}
