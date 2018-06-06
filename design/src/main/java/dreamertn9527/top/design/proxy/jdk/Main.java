package dreamertn9527.top.design.proxy.jdk;


import dreamertn9527.top.design.proxy.custom.SelfMeipo;

public class Main {
	public static void main(String[] args) {
		try {
//			Person person = (Person) new Meipo().getInstance(new Xiaoxinxin());
//			person.findLove();
//			System.out.println(person.getClass());
//			
//			// 实现原理：
//			// 1. 拿到被代理对象的引用，获取他的接口
//			// 2. jdk代理就会重新生成一个类，同时实现我们给的代理对象所实现的接口
//			// 3. 同时把被代理对象的引用也拿到了
//			// 4. 通过invoick重新生成一个class字节码，然后编译
//			
//			byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{person.getClass()});
//			FileOutputStream os = new FileOutputStream("$Proxy0.class");
//			os.write(data);
//			os.close();
			 
			Person person = (Person) new SelfMeipo().getInstance(new Xiaoxinxin());
			person.findLove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
