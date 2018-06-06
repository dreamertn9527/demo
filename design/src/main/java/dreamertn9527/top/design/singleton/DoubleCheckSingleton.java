package dreamertn9527.top.design.singleton;


/**
 * 
 * 单例模式之DoubleCheck
 * @author tangniannian
 * 2018年1月16日下午3:09:22
 */
public class DoubleCheckSingleton {

	private volatile static  DoubleCheckSingleton instance = null;
	
	/**
	 * 私有方法防止外部实例化
	 */
	private DoubleCheckSingleton(){
		
	}
	
	
	/**
	 * 双重检查锁获取单例
	 * @return
	 * @description:
	 * @author tangniannian 2018年1月16日
	 * 
	 * @description:
	 * @modifier
	 *
	 */
	public static DoubleCheckSingleton getInstance(){
		if(instance == null){
			synchronized(DoubleCheckSingleton.class){
				if(instance == null){
					instance = new DoubleCheckSingleton();
				}
			}
		}
		
		
		return instance;
	}
}
