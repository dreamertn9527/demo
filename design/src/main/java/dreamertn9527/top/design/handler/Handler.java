package dreamertn9527.top.design.handler;


/**
 * 
 * 责任链模式
 * @author tangniannian
 * 2018年2月9日上午10:08:47
 */
public abstract class Handler {

	private Handler nextHandler = null;
	
	public void setNextHandler(Handler handler){
		nextHandler = handler;
	}
	
	public final Response handlerRequest(Request request) {
        Response response = null;
        if(this.getHandlerLevel().above(request.getLevel())) {
            response = this.response(request);
        }else {
            if(nextHandler != null) {
                response = this.nextHandler.handlerRequest(request);
            }else {
                System.out.println("没有合适的处理器处理该请求...");
            }
        }
        return response;
    }
	
	
	protected abstract Level getHandlerLevel();
	
    public abstract Response response(Request request); 
}
