package dreamertn9527.top.design.handler;

public class Main {

	public static void main(String[] args) {
		Handler hd1 = new ConcreteHandler1();
		Handler hd2 = new ConcreteHandler2();
		Handler hd3 = new ConcreteHandler3();
		
		hd1.setNextHandler(hd2);
		hd2.setNextHandler(hd3);
		
		Response res1 = hd1.handlerRequest(new Request(new Level(3)));
		if(res1 != null){
			System.out.println(res1.getMessage());
		}
		
//		Response res2 = hd1.handlerRequest(new Request(new Level(2)));
//        if (res2 != null) {
//            System.out.println(res2.getMessage());
//        }
	}
	
}



class ConcreteHandler1 extends Handler{

	@Override
	protected Level getHandlerLevel() {
		return new Level(1);
	}

	@Override
	public Response response(Request request) {
		System.out.println("该请求由 ConcreteHandler1 处理");
		return new Response("响应结果：1");
	}
	
}



class ConcreteHandler2 extends Handler{

	@Override
	protected Level getHandlerLevel() {
		return new Level(2);
	}

	@Override
	public Response response(Request request) {
		System.out.println("该请求由 ConcreteHandler2 处理");
		return new Response("响应结果：2");
	}
	
}


class ConcreteHandler3 extends Handler{

	@Override
	protected Level getHandlerLevel() {
		return new Level(3);
	}

	@Override
	public Response response(Request request) {
		System.out.println("该请求由 ConcreteHandler3 处理");
		return new Response("响应结果：3");
	}
	
}
