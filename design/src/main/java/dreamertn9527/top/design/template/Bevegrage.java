package dreamertn9527.top.design.template;

public abstract class Bevegrage {

	/**
	 * 该方法不可以被重写
	 */
	public final void create(){
		// 1. 把水烧开
		boilWater();
		// 2. 把杯子准备好，把原材料放入杯子
		pourInCup();
		// 3. 用水冲泡
		brew();
		// 4. 加入辅料
		addCoundiments();
		
	}
	
	/**
	 * 烧开水
	 */
	public void boilWater(){
		System.out.println("烧开水，烧到100摄氏度");
	}
	
	/**
	 * 放入原料
	 */
	public abstract void pourInCup();
	
	public void brew(){
		System.out.println("将开水倒入杯中");
	}
	
	
	public abstract void addCoundiments();
}
