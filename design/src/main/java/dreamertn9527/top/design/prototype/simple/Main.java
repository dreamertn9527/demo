package dreamertn9527.top.design.prototype.simple;


/**
 * 原型模式
 * @author tangniannian
 *
 */
public class Main {

	public static void main(String[] args) {
		ConcreteProtopyte cp = new ConcreteProtopyte();
		cp.setAge(18);
		cp.setName("dreamertn9527");
		cp.list.add("dreamertn9527");
		
		try {
			ConcreteProtopyte copy = (ConcreteProtopyte) cp.clone();
			// 引用的是同一个对象，浅度复制
			System.out.println(copy.list == cp.list);
			System.out.println(copy.getAge()+","+copy.getName());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 原型模式就是有一个现成的对象，该对象已经设置好了对应的属性
		// 当新建一个对象时，并且要给这个新建的对象赋值，且赋值内容要跟之前的一模一样
		
		// 传统的做法是先new一个对象，然后设置对应的值
		// 而现在只需要使用对应的clone方法就可以得到一个对应的新的对象
		// 例如，下面的传统模式
//		ConcreteProtopyte copy = new ConcreteProtopyte();
//		cp.setAge(cp.getAge());
//		cp.setName(cp.getName());
		
		// clone不走构造方法，直接生成对象，常用于ORM
		
		// 深度拷贝和浅度拷贝
		// 浅拷贝：能够直接拷贝其实际内容的数据类型（只支持9种），8大基本类型及String类型
		// 深拷贝：需要重写对应对象的clone()方法
		
		
	}
}
