package dreamertn9527.top.design.prototype.greatestage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class TheGreatestSage extends Monkey implements Cloneable, Serializable{

	private GoldRingedStaff staff;
	
	public TheGreatestSage(){
		this.staff = new GoldRingedStaff();
		this.height = 160;
		this.weight = 50;
		this.birthday = new Date();
		System.out.println("克隆是不走构造方法的，直接是走字节流复制");
	}
	
//	// 浅克隆，对象为同一个对象
//	public Object clone(){
//		Object obj = null;
//		try {
//			 obj = super.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return obj;
//	}
	
	/**
	 * 使用序列化实现深度克隆
	 */
	public Object clone(){
		Object obj = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);

			TheGreatestSage copy = (TheGreatestSage) ois.readObject();
			copy.setBirthday(new Date());
			obj = copy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				oos.close();
				
				bis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return obj;
	}
	
	public void change(){
		TheGreatestSage copy = (TheGreatestSage) clone();
		System.out.println("大圣的本尊的生日是："+this.getBirthday().getTime());
		System.out.println("大圣克隆的生日是："+copy.getBirthday().getTime());
		System.out.println("大圣和克隆的大圣是否是同一个对象："+ (this == copy));
		System.out.println("大圣和克隆的金箍棒是否是同一个："+ (this.staff == copy.staff));
	}

	public GoldRingedStaff getStaff() {
		return staff;
	}

	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}
	
}
