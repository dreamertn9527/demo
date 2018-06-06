package dreamertn9527.top.design.singleton;

public class StaticInnerClassSingleton {

	private StaticInnerClassSingleton(){}
	
	private static class Singleton{
		private final static Singleton instance = new Singleton(); 
	}
	
	public static Singleton getInstance(){
		return Singleton.instance;
	}
}
