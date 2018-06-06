package dreamertn9527.top.design.timmer;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 计时工具类
 * @author tangniannian
 * 2018年2月24日下午2:46:08
 */
public class Timmer implements MethodInterceptor{

	
	private Timmer(){}
	
	/**
	 * 
	 * @description: 获取代理类对象
	 * @author tangniannian 2018年2月24日
	 * 
	 * @description:
	 * @modifier
	 *
	 */
	private Object getInstance(Class clazz) throws Exception{
		Enhancer enhancer = new Enhancer();
		
		// 把父类设置为谁
		// 这一步就是告诉cglib，生成的子类需要继承哪个类
		enhancer.setSuperclass(clazz);
		
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
		
		long start = System.currentTimeMillis();
		// 代理类对象进行方法调用，计算时间开始
		
		proxy.invokeSuper(obj, args);
		
		long end = System.currentTimeMillis();
		
		System.out.println(obj.getClass().getSimpleName()+"---共耗时---"+(end-start)+"ms");
		
		return null;
	}
	
	
	public static Object getObject(Class clazz) {
		Object obj = null;
		try {
			obj = new Timmer().getInstance(clazz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
}
