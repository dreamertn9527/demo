package dreamertn9527.top.design.delegate;

public class Dispatcher implements IDelegate{

	private IDelegate delegate;
	
	public Dispatcher(IDelegate delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public void doing() {
		this.delegate.doing();
	}

}
