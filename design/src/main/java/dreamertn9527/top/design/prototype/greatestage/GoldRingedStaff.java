package dreamertn9527.top.design.prototype.greatestage;

import java.io.Serializable;

public class GoldRingedStaff implements Serializable{

	private float height = 100;
	private float diameter = 10;
	
	public void grow(){
		this.height *= 2;
		this.diameter *= 2;
	}
	
	public void shrink(){
		this.height /= 2;
		this.diameter /= 2;
	}
}
