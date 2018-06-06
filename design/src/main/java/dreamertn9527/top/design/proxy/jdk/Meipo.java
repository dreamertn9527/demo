package dreamertn9527.top.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 代理人
 * @author tangniannian
 *
 */
public class Meipo implements InvocationHandler{

	// 被代理对象的引用作为一个成员变量保存下来了
	private Person target;
	
	// 获取被代理人的个人资料
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		Class clazz = target.getClass();
		System.out.println("被代理对象的Class是："+ clazz);
		// 返回被代理人对象
		return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}
	
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("得找一个异性给你");
		System.out.println("开始进行海选...");
		System.out.println("------");
		
		// 调用的时候，必须是对象
		method.invoke(this.target, args);
		System.out.println("------");
		System.out.println("如果合适，就准备在一起");
		
		return null;
	}

}
