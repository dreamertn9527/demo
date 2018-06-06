package dreamertn9527.top.design.proxy.custom;

import java.lang.reflect.Method;

public interface SelfInvocatationHandler {
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
