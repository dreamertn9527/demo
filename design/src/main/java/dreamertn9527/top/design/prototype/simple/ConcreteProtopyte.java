package dreamertn9527.top.design.prototype.simple;

import java.util.ArrayList;

/**
 * 原型模式
 * 应用场景：为了解决复制问题
 * @author tangniannian
 *
 */
public class ConcreteProtopyte implements Cloneable{

	private int age;
	
	private String name;
	
	public ArrayList<String> list = new ArrayList<String>();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	protected Object clone() throws CloneNotSupportedException{
		ConcreteProtopyte prototype = null;
		prototype = (ConcreteProtopyte) super.clone();
		
		// 重写对象的clone方法，但是无法处理对象中含有
		prototype.list = (ArrayList<String>) list.clone();
		
		// 因为克隆是基于字节码的，所以可以用for循环或者反射来进行深度克隆
		
		return prototype;
	}
	
}
