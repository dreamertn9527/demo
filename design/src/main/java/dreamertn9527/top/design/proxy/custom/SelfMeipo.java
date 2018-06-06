package dreamertn9527.top.design.proxy.custom;

import dreamertn9527.top.design.proxy.jdk.Person;

import java.lang.reflect.Method;


public class SelfMeipo implements SelfInvocatationHandler {

	private Person target;
	
	// 获取被代理人的个人资料
	public Object getInstance(Person target) throws Exception{
		this.target = target;
		Class clazz = target.getClass();
		System.out.println("被代理对象的Class是："+ clazz);
		// 返回被代理人对象
		return SelfProxy.newProxyInstance(new SelfClassLoader(), clazz.getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("得找一个异性给你");
		System.out.println("开始进行海选...");
		System.out.println("------");
//		this.target.findLove();
		method.invoke(this.target, args);
		System.out.println("------");
		System.out.println("如果合适，就准备在一起");
		
		return null;
	}
	
	
	
}
