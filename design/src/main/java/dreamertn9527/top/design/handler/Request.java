package dreamertn9527.top.design.handler;

public class Request {

	private Level level;
	
	public Request(Level level){
		System.out.println("开始请求...");
		this.level = level;
	}
	
	public Level getLevel(){
		return level;
	}
}
